package org.eclipse.gmf.codegen.templates.diacanvas;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;

public class PluginXML
{
  protected static String nl;
  public static synchronized PluginXML create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginXML result = new PluginXML();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL + "<plugin" + NL + "    name=\"";
  protected final String TEXT_2 = "\"" + NL + "    id=\"";
  protected final String TEXT_3 = "\"" + NL + "    version=\"1.0.0\"" + NL + "    class=\"";
  protected final String TEXT_4 = "\"" + NL + "    provider-name = \"";
  protected final String TEXT_5 = "\">" + NL + "" + NL + "  <requires>" + NL + "    <import plugin=\"org.eclipse.core.runtime\"/>" + NL + "    <import plugin=\"org.eclipse.core.resources\"/>" + NL + "    <import plugin=\"org.eclipse.jface\"/>" + NL + "    <import plugin=\"org.eclipse.ui.ide\"/>" + NL + "    <import plugin=\"org.eclipse.ui.views\"/>" + NL + "    <import plugin=\"org.eclipse.ui.workbench\"/>" + NL + "    <import plugin=\"org.eclipse.emf.ecore\"/>";
  protected final String TEXT_6 = NL + "    <import plugin=\"org.eclipse.emf.edit.ui\"/>" + NL + "    <import plugin=\"org.eclipse.gef\" export=\"true\"/>" + NL + "    <import plugin=\"";
  protected final String TEXT_7 = "\" export=\"true\"/>" + NL + "    <import plugin=\"org.eclipse.gmf.runtime.gef\"/>" + NL + "    <import plugin=\"org.eclipse.gmf.edit\"/>" + NL + "    <import plugin=\"";
  protected final String TEXT_8 = "\" export=\"true\"/>";
  protected final String TEXT_9 = NL + "    <import plugin=\"";
  protected final String TEXT_10 = "\" export=\"true\"/>";
  protected final String TEXT_11 = NL + "    <import plugin=\"";
  protected final String TEXT_12 = "\" export=\"true\"/>";
  protected final String TEXT_13 = NL + "  </requires>" + NL + "" + NL + "  <runtime>" + NL + "    <library name=\"plugin.jar\">" + NL + "      <export name=\"*\"/>" + NL + "    </library>" + NL + "  </runtime>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.editors\">" + NL + "     <editor " + NL + "        id=\"";
  protected final String TEXT_14 = "_EditorID\"" + NL + "        name=\"Diagram Editor for ";
  protected final String TEXT_15 = "\"" + NL + "        icon=\"none\"" + NL + "        extensions=\"";
  protected final String TEXT_16 = "\"" + NL + "        class=\"";
  protected final String TEXT_17 = "\"" + NL + "        contributorClass=\"org.eclipse.ui.part.EditorActionBarContributor\"/>" + NL + "    " + NL + "   </extension>" + NL + "   <extension point=\"org.eclipse.ui.popupMenus\">" + NL + "      <objectContribution" + NL + "            adaptable=\"true\"" + NL + "            id=\"";
  protected final String TEXT_18 = ".ui.contribution1\"" + NL + "            objectClass=\"org.eclipse.core.resources.IContainer\">" + NL + "         <action" + NL + "               label=\"Create empty ";
  protected final String TEXT_19 = " diagram file\"" + NL + "               class=\"org.eclipse.gmf.runtime.actions.NewDiagramAction\"" + NL + "               menubarPath=\"additions\"" + NL + "               defaultName=\"example1\"" + NL + "               fileExtension=\"";
  protected final String TEXT_20 = "\"" + NL + "               rtModelNsURI=\"";
  protected final String TEXT_21 = "\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_22 = ".ui.newDiagramAction\">" + NL + "         </action>" + NL + "      </objectContribution>" + NL + "      <objectContribution" + NL + "            id=\"";
  protected final String TEXT_23 = ".ui.contribution2\"" + NL + "            nameFilter=\"*.";
  protected final String TEXT_24 = "\"" + NL + "            objectClass=\"org.eclipse.core.resources.IFile\">" + NL + "         <action" + NL + "               label=\"Initialize ";
  protected final String TEXT_25 = " diagram file\"" + NL + "               class=\"";
  protected final String TEXT_26 = "\"" + NL + "               menubarPath=\"additions\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_27 = ".ui.InitDiagramFileAction\">" + NL + "         </action>" + NL + "      </objectContribution>            " + NL + "  </extension>" + NL + "  <extension point=\"org.eclipse.team.core.fileTypes\">" + NL + "      <fileTypes" + NL + "            type=\"text\"" + NL + "            extension=\"";
  protected final String TEXT_28 = "\">" + NL + "      </fileTypes>" + NL + "  </extension>" + NL + "</plugin>";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEmfGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getPluginName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getPluginQualifiedClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getProviderName());
    stringBuffer.append(TEXT_5);
    
	// XXX org.eclipse.emf.edit.ui is for ExtendedImageRegistry. 
	// FIXME move image registry to plugin class code

    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getDiagramRunTimeClass().getGenModel().getModelPluginID());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genModel.getModelPluginID());
    stringBuffer.append(TEXT_8);
    if (!genModel.sameModelEditProject()) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getEditPluginID());
    stringBuffer.append(TEXT_10);
    }
    
String[] requiredPlugins = genDiagram.getRequiredPluginIDs();
if (requiredPlugins == null) {
	requiredPlugins = new String[0];
}
for (Iterator it = Arrays.asList(requiredPlugins).iterator(); it.hasNext();) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(it.next());
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genDiagram.getDiagramRunTimeClass().getGenPackage().getEcorePackage().getNsURI());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genModel.findGenPackage(genDiagram.getDomainDiagramElement().getEPackage()).getPrefix().toLowerCase());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
