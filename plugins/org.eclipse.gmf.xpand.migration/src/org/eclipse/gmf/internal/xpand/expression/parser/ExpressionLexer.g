--
-- Copyright (c) 2006 Borland Software Corp.
-- 
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the Eclipse Public License v1.0
-- which accompanies this distribution, and is available at
-- http://www.eclipse.org/legal/epl-v10.html
--
-- Contributors:
--    Artem Tikhomirov (Borland)
--

%options fp=ExpressionLexer,prefix=Char_
%options single-productions
%options package=org.eclipse.gmf.internal.xpand.expression.parser
%options template=LexerTemplateD.g
%options export_terminals=("ExpressionParsersym.java", "TK_")
%options filter=ExpressionKWLexer.g
%options la=2

$Notice
/./*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/./
$End

$Define
	$kw_lexer_class /.ExpressionKWLexer./
	$_IDENTIFIER /.$_IDENT./
	$getKindMethodImpl /.public final int getKind(int i) { // Classify character at ith location
            char c = (i >= getStreamLength() ? '\uffff' : getCharValue(i));
            return (c < 128 // ASCII Character
                      ? tokenKind[c]
                      : c == '\uffff'
                           ? Char_EOF
                           : Char_AfterASCII);
        }./
$End

-- COPY OF LexerBasicMap.g, instead of $Include
-- CHANGES: methods referencing Options class were removed
--          printValues and boolean attribute to control that were removed
--          getKind() extracted into separate overridable macro $getKindMethodImpl
$Headers
    --
    -- Additional methods for the action class not provided in the template
    --
    /.
        //
        // The Lexer contains an array of characters as the input stream to be parsed.
        // There are methods to retrieve and classify characters.
        // The lexparser "token" is implemented simply as the index of the next character in the array.
        // The Lexer extends the abstract class LpgLexStream with an implementation of the abstract
        // method getKind.  The template defines the Lexer class and the lexer() method.
        // A driver creates the action class, "Lexer", passing an Option object to the constructor.
        //
        private $kw_lexer_class kwLexer;
        private final static int ECLIPSE_TAB_VALUE = 4;

        public int [] getKeywordKinds() { return kwLexer.getKeywordKinds(); }

        public $action_type(String filename) throws java.io.IOException {
            this(filename, ECLIPSE_TAB_VALUE);
            this.kwLexer = new $kw_lexer_class(getInputChars(), $_IDENTIFIER);
        }

        public void initialize(char [] content, String filename) {
            super.initialize(content, filename);
            if (this.kwLexer == null) {
                 this.kwLexer = new $kw_lexer_class(getInputChars(), $_IDENTIFIER);
            } else {
            	this.kwLexer.setInputChars(getInputChars());
            }
        }
        
        final void makeToken(int kind) {
            int startOffset = getLeftSpan(),
                endOffset = getRightSpan();
            makeToken(startOffset, endOffset, kind);
        }

        final void makeComment(int kind) {
            int startOffset = getLeftSpan(),
                endOffset = getRightSpan();
            super.getPrsStream().makeAdjunct(startOffset, endOffset, kind);
        }

        final void skipToken() {
        }
        
        final void checkForKeyWord() {
            int startOffset = getLeftSpan(),
                endOffset = getRightSpan(),
            kwKind = kwLexer.lexer(startOffset, endOffset);
            makeToken(startOffset, endOffset, kwKind);
        }
        
        //
        //
        //
        public final static int tokenKind[] = {
            Char_CtlCharNotWS,    // 000    0x00
            Char_CtlCharNotWS,    // 001    0x01
            Char_CtlCharNotWS,    // 002    0x02
            Char_CtlCharNotWS,    // 003    0x03
            Char_CtlCharNotWS,    // 004    0x04
            Char_CtlCharNotWS,    // 005    0x05
            Char_CtlCharNotWS,    // 006    0x06
            Char_CtlCharNotWS,    // 007    0x07
            Char_CtlCharNotWS,    // 008    0x08
            Char_HT,              // 009    0x09
            Char_LF,              // 010    0x0A
            Char_CtlCharNotWS,    // 011    0x0B
            Char_FF,              // 012    0x0C
            Char_CR,              // 013    0x0D
            Char_CtlCharNotWS,    // 014    0x0E
            Char_CtlCharNotWS,    // 015    0x0F
            Char_CtlCharNotWS,    // 016    0x10
            Char_CtlCharNotWS,    // 017    0x11
            Char_CtlCharNotWS,    // 018    0x12
            Char_CtlCharNotWS,    // 019    0x13
            Char_CtlCharNotWS,    // 020    0x14
            Char_CtlCharNotWS,    // 021    0x15
            Char_CtlCharNotWS,    // 022    0x16
            Char_CtlCharNotWS,    // 023    0x17
            Char_CtlCharNotWS,    // 024    0x18
            Char_CtlCharNotWS,    // 025    0x19
            Char_CtlCharNotWS,    // 026    0x1A
            Char_CtlCharNotWS,    // 027    0x1B
            Char_CtlCharNotWS,    // 028    0x1C
            Char_CtlCharNotWS,    // 029    0x1D
            Char_CtlCharNotWS,    // 030    0x1E
            Char_CtlCharNotWS,    // 031    0x1F
            Char_Space,           // 032    0x20
            Char_Exclamation,     // 033    0x21
            Char_DoubleQuote,     // 034    0x22
            Char_Sharp,           // 035    0x23
            Char_DollarSign,      // 036    0x24
            Char_Percent,         // 037    0x25
            Char_Ampersand,       // 038    0x26
            Char_SingleQuote,     // 039    0x27
            Char_LeftParen,       // 040    0x28
            Char_RightParen,      // 041    0x29
            Char_Star,            // 042    0x2A
            Char_Plus,            // 043    0x2B
            Char_Comma,           // 044    0x2C
            Char_Minus,           // 045    0x2D
            Char_Dot,             // 046    0x2E
            Char_Slash,           // 047    0x2F
            Char_0,               // 048    0x30
            Char_1,               // 049    0x31
            Char_2,               // 050    0x32
            Char_3,               // 051    0x33
            Char_4,               // 052    0x34
            Char_5,               // 053    0x35
            Char_6,               // 054    0x36
            Char_7,               // 055    0x37
            Char_8,               // 056    0x38
            Char_9,               // 057    0x39
            Char_Colon,           // 058    0x3A
            Char_SemiColon,       // 059    0x3B
            Char_LessThan,        // 060    0x3C
            Char_Equal,           // 061    0x3D
            Char_GreaterThan,     // 062    0x3E
            Char_QuestionMark,    // 063    0x3F
            Char_AtSign,          // 064    0x40
            Char_A,               // 065    0x41
            Char_B,               // 066    0x42
            Char_C,               // 067    0x43
            Char_D,               // 068    0x44
            Char_E,               // 069    0x45
            Char_F,               // 070    0x46
            Char_G,               // 071    0x47
            Char_H,               // 072    0x48
            Char_I,               // 073    0x49
            Char_J,               // 074    0x4A
            Char_K,               // 075    0x4B
            Char_L,               // 076    0x4C
            Char_M,               // 077    0x4D
            Char_N,               // 078    0x4E
            Char_O,               // 079    0x4F
            Char_P,               // 080    0x50
            Char_Q,               // 081    0x51
            Char_R,               // 082    0x52
            Char_S,               // 083    0x53
            Char_T,               // 084    0x54
            Char_U,               // 085    0x55
            Char_V,               // 086    0x56
            Char_W,               // 087    0x57
            Char_X,               // 088    0x58
            Char_Y,               // 089    0x59
            Char_Z,               // 090    0x5A
            Char_LeftBracket,     // 091    0x5B
            Char_BackSlash,       // 092    0x5C
            Char_RightBracket,    // 093    0x5D
            Char_Caret,           // 094    0x5E
            Char__,               // 095    0x5F
            Char_BackQuote,       // 096    0x60
            Char_a,               // 097    0x61
            Char_b,               // 098    0x62
            Char_c,               // 099    0x63
            Char_d,               // 100    0x64
            Char_e,               // 101    0x65
            Char_f,               // 102    0x66
            Char_g,               // 103    0x67
            Char_h,               // 104    0x68
            Char_i,               // 105    0x69
            Char_j,               // 106    0x6A
            Char_k,               // 107    0x6B
            Char_l,               // 108    0x6C
            Char_m,               // 109    0x6D
            Char_n,               // 110    0x6E
            Char_o,               // 111    0x6F
            Char_p,               // 112    0x70
            Char_q,               // 113    0x71
            Char_r,               // 114    0x72
            Char_s,               // 115    0x73
            Char_t,               // 116    0x74
            Char_u,               // 117    0x75
            Char_v,               // 118    0x76
            Char_w,               // 119    0x77
            Char_x,               // 120    0x78
            Char_y,               // 121    0x79
            Char_z,               // 122    0x7A
            Char_LeftBrace,       // 123    0x7B
            Char_VerticalBar,     // 124    0x7C
            Char_RightBrace,      // 125    0x7D
            Char_Tilde,           // 126    0x7E

            Char_AfterASCII,      // for all chars in range 128..65534
            Char_EOF              // for '\uffff' or 65535 
        };
                
        $getKindMethodImpl
    ./
$End
-- COPY OF LexerBasicMap.g ENDS


$Export
	IDENT  STRING  INT_CONST  REAL_CONST

	QUESTION_MARK
	DCOLON
	COLON
	LPAREN
	RPAREN
	LCURLY
	RCURLY
	LSQUARE
	RSQUARE
	ARROW
	NOT
	AND
	OR

	ASSIGN
	EQ
	NE
	GE
	LE
	GT
	LT

	PLUS
	MINUS

	MULTI
	DIV

	DOT
	COMMA

	BAR
$End

$Terminals
	CtlCharNotWS

	LF   CR   HT   FF

	a b c d e f g h i j k l m n o p q r s t u v w x y z
	_

	A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

	0 1 2 3 4 5 6 7 8 9

	Space        ::= ' '
	LF           ::= NewLine
	CR           ::= Return
	HT           ::= HorizontalTab
	FF           ::= FormFeed
	DoubleQuote  ::= '"'
	SingleQuote  ::= "'"
	Percent      ::= '%'
	VerticalBar  ::= '|'
	Exclamation  ::= '!'
	AtSign       ::= '@'
	BackQuote    ::= '`'
	Acute        ::= '�'
	Tilde        ::= '~'
	Sharp        ::= '#'
	DollarSign   ::= '$'
	Ampersand    ::= '&'
	Caret        ::= '^'
	Colon        ::= ':'
	SemiColon    ::= ';'
	BackSlash    ::= '\'
	LeftBrace    ::= '{'
	RightBrace   ::= '}'
	LeftBracket  ::= '['
	RightBracket ::= ']'
	QuestionMark ::= '?'
	Comma        ::= ','
	Dot          ::= '.'
	LessThan     ::= '<'
	GreaterThan  ::= '>'
	Plus         ::= '+'
	Minus        ::= '-'
	Slash        ::= '/'
	Star         ::= '*'
	LeftParen    ::= '('
	RightParen   ::= ')'
	Equal        ::= '='
    AfterASCII   ::= '\u0080..\ufffe'

$End

$Start
	Token
$End

$Rules
	Token ::= Identifier
		/.$BeginAction
				checkForKeyWord();
		$EndAction./

	-- unlike original xpand, do not support multiline strings
	Token ::= SingleQuote SLNotSQOpt SingleQuote
		/.$BeginAction
				makeToken($_STRING);
		$EndAction./

	-- unlike original xpand, do not support multiline strings
	Token ::= DoubleQuote SLNotSQOpt DoubleQuote
		/.$BeginAction
				makeToken($_STRING);
		$EndAction./

	Token ::= Integer
		/.$BeginAction
				makeToken($_INT_CONST);
		$EndAction./

	Token ::= Integer '.' Identifier
		/.$BeginAction
				makeToken(getRhsFirstTokenIndex(1), getRhsLastTokenIndex(1), $_INT_CONST);
				makeToken(getRhsFirstTokenIndex(2), getRhsLastTokenIndex(2), $_DOT);
				makeToken(getRhsFirstTokenIndex(3), getRhsLastTokenIndex(3), $_IDENT);
		$EndAction./

	Token ::= Decimal
		/.$BeginAction
				makeToken($_REAL_CONST);
		$EndAction./

	Token ::= '+'
		/.$BeginAction
				makeToken($_PLUS);
		$EndAction./

	Token ::= '-'
		/.$BeginAction
				makeToken($_MINUS);
		$EndAction./

	Token ::= '*'
		/.$BeginAction
				makeToken($_MULTI);
		$EndAction./

	Token ::= '/'
		/.$BeginAction
				makeToken($_DIV);
		$EndAction./

	Token ::= '&' '&'
		/.$BeginAction
				makeToken($_AND);
		$EndAction./

	Token ::= '|' '|'
		/.$BeginAction
				makeToken($_OR);
		$EndAction./

	Token ::= '!'
		/.$BeginAction
				makeToken($_NOT);
		$EndAction./

	Token ::= '('
		/.$BeginAction
				makeToken($_LPAREN);
		$EndAction./

	Token ::= ')'
		/.$BeginAction
				makeToken($_RPAREN);
		$EndAction./

	Token ::= '>'
		/.$BeginAction
				makeToken($_GT);
		$EndAction./
		
	Token ::= '<'
		/.$BeginAction
				makeToken($_LT);
		$EndAction./

	Token ::= '=' '='
		/.$BeginAction
				makeToken($_EQ);
		$EndAction./

	Token ::= '>' '='
		/.$BeginAction
				makeToken($_GE);
		$EndAction./

	Token ::= '<' '='
		/.$BeginAction
				makeToken($_LE);
		$EndAction./

	Token ::= '!' '='
		/.$BeginAction
				makeToken($_NE);
		$EndAction./

	Token ::= '['
		/.$BeginAction
				makeToken($_LSQUARE);
		$EndAction./

	Token ::= ']'
		/.$BeginAction
				makeToken($_RSQUARE);
		$EndAction./

	Token ::= '{'
		/.$BeginAction
				makeToken($_LCURLY);
		$EndAction./

	Token ::= '}'
		/.$BeginAction
				makeToken($_RCURLY);
		$EndAction./

	Token ::= '-' '>'
		/.$BeginAction
				makeToken($_ARROW);
		$EndAction./

	Token ::= '|'
		/.$BeginAction
				makeToken($_BAR);
		$EndAction./

	Token ::= ','
		/.$BeginAction
				makeToken($_COMMA);
		$EndAction./

	Token ::= ':'
		/.$BeginAction
				makeToken($_COLON);
		$EndAction./

	Token ::= ':' ':'
		/.$BeginAction
				makeToken($_DCOLON);
		$EndAction./

	Token ::= '.'
		/.$BeginAction
				makeToken($_DOT);
		$EndAction./

	Token ::= '='
		/.$BeginAction
				makeToken($_ASSIGN);
		$EndAction./

	Token ::= '?'
		/.$BeginAction
				makeToken($_QUESTION_MARK);
		$EndAction./

	Token ::= WS
		/.$BeginAction
				skipToken();
		$EndAction./

    Token ::= '/' '*' Inside Stars '/'
        /.$BeginAction
				skipToken();
		$EndAction./

	Token ::= SLC
		/.$BeginAction
				skipToken();
		$EndAction./


    Integer -> Digit | Integer Digit

    Decimal -> Integer '.' Integer

    Identifier -> Letter
                | Identifier Letter
                | Identifier Digit

    Letter -> LowerCaseLetter | UpperCaseLetter | '_'

    LowerCaseLetter -> a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z
    UpperCaseLetter -> A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z
    Digit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    WSChar -> Space | LF | CR | HT | FF

    WS -> WSChar | WS WSChar

    SpecialNotSlash -> '+' | '-' | -- exclude the star as well
                       '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                       '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                       '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | '$'

	-- dumb copy from OCLLexer, not sure this is the best way to define single line comment
    SLC -> '/' '/' | SLC NotEol

    NotEol -> Letter | Digit | Space | '*' | '/' | SpecialNotSlash | HT | FF | CtlCharNotWS

    NotSlashOrStar -> Letter
                    | Digit
                    | SpecialNotSlash
                    | WSChar

    Inside ::= Inside Stars NotSlashOrStar
             | Inside '/'
             | Inside NotSlashOrStar
             | $empty

    Stars -> '*' | Stars '*'

	SLNotSQ -> NotSQ | SLNotSQ NotSQ

	SLNotSQOpt -> $empty | SLNotSQ

    SpecialNotSQ -> '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | '$'

    NotSQ -> Letter
           | Digit
           | SpecialNotSQ
           | Space
           | EscapeSequence
           | '\' u HexDigit HexDigit HexDigit HexDigit

    EscapeSequence ::= '\' b
                     | '\' t
                     | '\' n
                     | '\' f
                     | '\' r
                     | '\' '"'
                     | '\' "'"
                     | '\' '\'

    afAF -> a | b | c | d | e | f | A | B | C | D | E | F

    HexDigit -> Digit | afAF

$End