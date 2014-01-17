/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [235113] alternative parser access
 *                                 [244419] custom parsers
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package parsers

import com.google.inject.Inject
import xpt.Common
import org.eclipse.gmf.codegen.gmfgen.GenParsers
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet

@com.google.inject.Singleton class ParserProvider {
	@Inject extension Common;
	@Inject extension ParsersUtil;

	@Inject impl.parsers.ParserProvider xptImplParserProvider;

	def className(GenParsers it) '''«classNameGenParsers(it)»'''

	def packageName(GenParsers it) '''«packageNameGenParsers(it)»'''

	def qualifiedClassName(GenParsers it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenParsers it) '''«qualifiedClassName(it)»'''

	def Main(GenParsers it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)»«extendsList(it)»«implementsList(it)» {
			«FOR node : it.editorGen.diagram.nodesForTopLevel»
				«xptImplParserProvider.dispatch_parsers(node)»
			«ENDFOR»
			«FOR node : it.editorGen.diagram.nodesForInnerLevel»
				«xptImplParserProvider.dispatch_parsers(node)»
			«ENDFOR»
			«FOR link : it.editorGen.diagram.links»
				«xptImplParserProvider.dispatch_parsers(link)»
			«ENDFOR»
		
		«IF extensibleViaService»
			«xptImplParserProvider.getParserByVisualIdMethod(it)»
			«xptImplParserProvider.accessorMethod_delegate2providers(it)»
			«xptImplParserProvider.provider_getParserMethod(it)»
			«xptImplParserProvider.provider_providesMethod(it)»
			«xptImplParserProvider.HintAdapterClass(it)»
			«extraLineBreak»
		«ELSE»
			«xptImplParserProvider.accessorMethod_direct(it)»
		«ENDIF»
			«additions(it)»
		}
	'''

	def extendsList(GenParsers it) '''«IF extensibleViaService» extends org.eclipse.gmf.runtime.common.core.service.AbstractProvider«ENDIF»'''

	def implementsList(GenParsers it) '''«IF extensibleViaService» implements org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider«ENDIF»'''

	def additions(GenParsers it) ''''''

	/**
	 * @param it - aka hintHolder, visual element to present a text (i.e. one of Node's labels)
	 * @param elementTypeHolder - model element being displayed
	 * @param modelFacet - may be null
	 * @param parsedElement - accessor to EObject being edited 
	 */
	@MetaDef def accessorCall(GenCommonBase it, GenCommonBase elementTypeHolder, LabelModelFacet labelModelFacet,
		String parsedElement) '''
		«IF it.diagram.editorGen.labelParsers.extensibleViaService»
			«xptImplParserProvider.accessorCall_delegate2providers(it, elementTypeHolder, labelModelFacet, parsedElement)»
		«ELSE»
			«xptImplParserProvider.accessorCall_direct(it, elementTypeHolder, labelModelFacet, parsedElement)»
		«ENDIF»
	'''

}
