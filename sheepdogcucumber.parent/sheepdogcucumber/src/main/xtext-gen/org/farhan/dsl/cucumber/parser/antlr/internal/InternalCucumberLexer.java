package org.farhan.dsl.cucumber.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCucumberLexer extends Lexer {
    public static final int RULE_WORD=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__9=9;
    public static final int RULE_EOL=4;
    public static final int RULE_WS=7;
    public static final int RULE_RAWTEXT=5;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalCucumberLexer() {;} 
    public InternalCucumberLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCucumberLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalCucumber.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:11:6: ( 'Object:' )
            // InternalCucumber.g:11:8: 'Object:'
            {
            match("Object:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:12:7: ( 'Definition:' )
            // InternalCucumber.g:12:9: 'Definition:'
            {
            match("Definition:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:13:7: ( 'Parameters:' )
            // InternalCucumber.g:13:9: 'Parameters:'
            {
            match("Parameters:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:14:7: ( 'Feature:' )
            // InternalCucumber.g:14:9: 'Feature:'
            {
            match("Feature:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:15:7: ( 'Background:' )
            // InternalCucumber.g:15:9: 'Background:'
            {
            match("Background:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:16:7: ( 'Scenario:' )
            // InternalCucumber.g:16:9: 'Scenario:'
            {
            match("Scenario:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:17:7: ( 'Scenario Outline:' )
            // InternalCucumber.g:17:9: 'Scenario Outline:'
            {
            match("Scenario Outline:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:18:7: ( 'Examples:' )
            // InternalCucumber.g:18:9: 'Examples:'
            {
            match("Examples:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:19:7: ( '|' )
            // InternalCucumber.g:19:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:20:7: ( 'Given' )
            // InternalCucumber.g:20:9: 'Given'
            {
            match("Given"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:21:7: ( 'When' )
            // InternalCucumber.g:21:9: 'When'
            {
            match("When"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:22:7: ( 'Then' )
            // InternalCucumber.g:22:9: 'Then'
            {
            match("Then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:23:7: ( 'And' )
            // InternalCucumber.g:23:9: 'And'
            {
            match("And"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:24:7: ( 'But' )
            // InternalCucumber.g:24:9: 'But'
            {
            match("But"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:25:7: ( '*' )
            // InternalCucumber.g:25:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:26:7: ( '@' )
            // InternalCucumber.g:26:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1875:9: ( ( ' ' | '\\t' | '\\r' )+ )
            // InternalCucumber.g:1875:11: ( ' ' | '\\t' | '\\r' )+
            {
            // InternalCucumber.g:1875:11: ( ' ' | '\\t' | '\\r' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCucumber.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1877:17: ( '#' (~ ( '\\n' ) )* RULE_EOL )
            // InternalCucumber.g:1877:19: '#' (~ ( '\\n' ) )* RULE_EOL
            {
            match('#'); 
            // InternalCucumber.g:1877:23: (~ ( '\\n' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCucumber.g:1877:23: ~ ( '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            mRULE_EOL(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_EOL"
    public final void mRULE_EOL() throws RecognitionException {
        try {
            int _type = RULE_EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1879:10: ( ( '\\n' )+ )
            // InternalCucumber.g:1879:12: ( '\\n' )+
            {
            // InternalCucumber.g:1879:12: ( '\\n' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\n') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCucumber.g:1879:12: '\\n'
            	    {
            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EOL"

    // $ANTLR start "RULE_RAWTEXT"
    public final void mRULE_RAWTEXT() throws RecognitionException {
        try {
            int _type = RULE_RAWTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1881:14: ( '\"\"\"' '\\n' ( . )+ '\\n' ( ' ' )* '\"\"\"' )
            // InternalCucumber.g:1881:16: '\"\"\"' '\\n' ( . )+ '\\n' ( ' ' )* '\"\"\"'
            {
            match("\"\"\""); 

            match('\n'); 
            // InternalCucumber.g:1881:27: ( . )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // InternalCucumber.g:1881:27: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            match('\n'); 
            // InternalCucumber.g:1881:35: ( ' ' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCucumber.g:1881:35: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match("\"\"\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RAWTEXT"

    // $ANTLR start "RULE_WORD"
    public final void mRULE_WORD() throws RecognitionException {
        try {
            int _type = RULE_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1883:11: ( (~ ( ( ' ' | '\\t' | '\\r' | '\\n' ) ) )+ )
            // InternalCucumber.g:1883:13: (~ ( ( ' ' | '\\t' | '\\r' | '\\n' ) ) )+
            {
            // InternalCucumber.g:1883:13: (~ ( ( ' ' | '\\t' | '\\r' | '\\n' ) ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\b')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\u001F')||(LA6_0>='!' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCucumber.g:1883:13: ~ ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WORD"

    public void mTokens() throws RecognitionException {
        // InternalCucumber.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | RULE_WS | RULE_SL_COMMENT | RULE_EOL | RULE_RAWTEXT | RULE_WORD )
        int alt7=21;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // InternalCucumber.g:1:10: T__9
                {
                mT__9(); 

                }
                break;
            case 2 :
                // InternalCucumber.g:1:15: T__10
                {
                mT__10(); 

                }
                break;
            case 3 :
                // InternalCucumber.g:1:21: T__11
                {
                mT__11(); 

                }
                break;
            case 4 :
                // InternalCucumber.g:1:27: T__12
                {
                mT__12(); 

                }
                break;
            case 5 :
                // InternalCucumber.g:1:33: T__13
                {
                mT__13(); 

                }
                break;
            case 6 :
                // InternalCucumber.g:1:39: T__14
                {
                mT__14(); 

                }
                break;
            case 7 :
                // InternalCucumber.g:1:45: T__15
                {
                mT__15(); 

                }
                break;
            case 8 :
                // InternalCucumber.g:1:51: T__16
                {
                mT__16(); 

                }
                break;
            case 9 :
                // InternalCucumber.g:1:57: T__17
                {
                mT__17(); 

                }
                break;
            case 10 :
                // InternalCucumber.g:1:63: T__18
                {
                mT__18(); 

                }
                break;
            case 11 :
                // InternalCucumber.g:1:69: T__19
                {
                mT__19(); 

                }
                break;
            case 12 :
                // InternalCucumber.g:1:75: T__20
                {
                mT__20(); 

                }
                break;
            case 13 :
                // InternalCucumber.g:1:81: T__21
                {
                mT__21(); 

                }
                break;
            case 14 :
                // InternalCucumber.g:1:87: T__22
                {
                mT__22(); 

                }
                break;
            case 15 :
                // InternalCucumber.g:1:93: T__23
                {
                mT__23(); 

                }
                break;
            case 16 :
                // InternalCucumber.g:1:99: T__24
                {
                mT__24(); 

                }
                break;
            case 17 :
                // InternalCucumber.g:1:105: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 18 :
                // InternalCucumber.g:1:113: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 19 :
                // InternalCucumber.g:1:129: RULE_EOL
                {
                mRULE_EOL(); 

                }
                break;
            case 20 :
                // InternalCucumber.g:1:138: RULE_RAWTEXT
                {
                mRULE_RAWTEXT(); 

                }
                break;
            case 21 :
                // InternalCucumber.g:1:151: RULE_WORD
                {
                mRULE_WORD(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA4_eotS =
        "\7\uffff";
    static final String DFA4_eofS =
        "\7\uffff";
    static final String DFA4_minS =
        "\2\0\1\uffff\3\0\1\uffff";
    static final String DFA4_maxS =
        "\2\uffff\1\uffff\3\uffff\1\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\1\3\uffff\1\2";
    static final String DFA4_specialS =
        "\1\3\1\1\1\uffff\1\2\1\4\1\0\1\uffff}>";
    static final String[] DFA4_transitionS = {
            "\12\2\1\1\ufff5\2",
            "\40\2\1\3\1\2\1\4\uffdd\2",
            "",
            "\40\2\1\3\1\2\1\4\uffdd\2",
            "\42\2\1\5\uffdd\2",
            "\42\2\1\6\uffdd\2",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1881:27: ( . )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_5 = input.LA(1);

                        s = -1;
                        if ( (LA4_5=='\"') ) {s = 6;}

                        else if ( ((LA4_5>='\u0000' && LA4_5<='!')||(LA4_5>='#' && LA4_5<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_1 = input.LA(1);

                        s = -1;
                        if ( ((LA4_1>='\u0000' && LA4_1<='\u001F')||LA4_1=='!'||(LA4_1>='#' && LA4_1<='\uFFFF')) ) {s = 2;}

                        else if ( (LA4_1==' ') ) {s = 3;}

                        else if ( (LA4_1=='\"') ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_3 = input.LA(1);

                        s = -1;
                        if ( ((LA4_3>='\u0000' && LA4_3<='\u001F')||LA4_3=='!'||(LA4_3>='#' && LA4_3<='\uFFFF')) ) {s = 2;}

                        else if ( (LA4_3=='\"') ) {s = 4;}

                        else if ( (LA4_3==' ') ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_0 = input.LA(1);

                        s = -1;
                        if ( (LA4_0=='\n') ) {s = 1;}

                        else if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_4 = input.LA(1);

                        s = -1;
                        if ( (LA4_4=='\"') ) {s = 5;}

                        else if ( ((LA4_4>='\u0000' && LA4_4<='!')||(LA4_4>='#' && LA4_4<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA7_eotS =
        "\1\uffff\7\23\1\34\4\23\1\41\1\42\1\uffff\1\23\1\uffff\1\23\1\uffff\10\23\1\uffff\4\23\2\uffff\1\23\1\uffff\6\23\1\70\5\23\1\76\6\23\1\uffff\3\23\1\110\1\111\2\uffff\7\23\1\121\2\uffff\7\23\1\uffff\1\131\6\23\1\uffff\2\23\1\142\5\23\1\uffff\1\23\1\152\1\uffff\1\153\3\23\2\uffff\1\157\1\160\1\161\3\uffff";
    static final String DFA7_eofS =
        "\162\uffff";
    static final String DFA7_minS =
        "\1\0\1\142\1\145\1\141\1\145\1\141\1\143\1\170\1\0\1\151\2\150\1\156\2\0\1\uffff\1\0\1\uffff\1\42\1\uffff\1\152\1\146\1\162\1\141\1\143\1\164\1\145\1\141\1\uffff\1\166\2\145\1\144\2\uffff\1\0\1\uffff\1\42\1\145\1\151\1\141\1\164\1\153\1\0\1\156\1\155\1\145\2\156\1\0\1\12\1\143\1\156\1\155\1\165\1\147\1\uffff\1\141\1\160\1\156\2\0\2\uffff\1\164\1\151\1\145\3\162\1\154\1\0\2\uffff\1\72\2\164\1\145\1\157\1\151\1\145\1\uffff\1\0\1\151\1\145\1\72\1\165\1\157\1\163\1\uffff\1\157\1\162\1\0\1\156\1\40\1\72\1\156\1\163\1\uffff\1\144\1\0\1\uffff\1\0\3\72\2\uffff\3\0\3\uffff";
    static final String DFA7_maxS =
        "\1\uffff\1\142\1\145\1\141\1\145\1\165\1\143\1\170\1\uffff\1\151\2\150\1\156\2\uffff\1\uffff\1\uffff\1\uffff\1\42\1\uffff\1\152\1\146\1\162\1\141\1\143\1\164\1\145\1\141\1\uffff\1\166\2\145\1\144\2\uffff\1\uffff\1\uffff\1\42\1\145\1\151\1\141\1\164\1\153\1\uffff\1\156\1\155\1\145\2\156\1\uffff\1\12\1\143\1\156\1\155\1\165\1\147\1\uffff\1\141\1\160\1\156\2\uffff\2\uffff\1\164\1\151\1\145\3\162\1\154\1\uffff\2\uffff\1\72\2\164\1\145\1\157\1\151\1\145\1\uffff\1\uffff\1\151\1\145\1\72\1\165\1\157\1\163\1\uffff\1\157\1\162\1\uffff\1\156\2\72\1\156\1\163\1\uffff\1\144\1\uffff\1\uffff\1\uffff\3\72\2\uffff\3\uffff\3\uffff";
    static final String DFA7_acceptS =
        "\17\uffff\1\21\1\uffff\1\23\1\uffff\1\25\10\uffff\1\11\4\uffff\1\17\1\20\1\uffff\1\22\23\uffff\1\16\5\uffff\1\15\1\24\10\uffff\1\13\1\14\7\uffff\1\12\7\uffff\1\1\10\uffff\1\4\2\uffff\1\7\4\uffff\1\6\1\10\3\uffff\1\2\1\3\1\5";
    static final String DFA7_specialS =
        "\1\16\7\uffff\1\21\4\uffff\1\5\1\7\1\uffff\1\11\22\uffff\1\17\7\uffff\1\4\5\uffff\1\3\12\uffff\1\1\1\2\11\uffff\1\0\12\uffff\1\6\11\uffff\1\13\7\uffff\1\15\1\uffff\1\20\5\uffff\1\10\1\12\1\14\3\uffff}>";
    static final String[] DFA7_transitionS = {
            "\11\23\1\17\1\21\2\23\1\17\22\23\1\17\1\23\1\22\1\20\6\23\1\15\25\23\1\16\1\14\1\5\1\23\1\2\1\7\1\4\1\11\7\23\1\1\1\3\2\23\1\6\1\13\2\23\1\12\44\23\1\10\uff83\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30\23\uffff\1\31",
            "\1\32",
            "\1\33",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "",
            "\11\43\2\44\2\43\1\44\22\43\1\44\uffdf\43",
            "",
            "\1\45",
            "",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "",
            "",
            "\11\43\2\44\2\43\1\44\22\43\1\44\uffdf\43",
            "",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "",
            "",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "",
            "",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\1\140",
            "\1\141",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\1\143",
            "\1\145\31\uffff\1\144",
            "\1\146",
            "\1\147",
            "\1\150",
            "",
            "\1\151",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\1\154",
            "\1\155",
            "\1\156",
            "",
            "",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "\11\23\2\uffff\2\23\1\uffff\22\23\1\uffff\uffdf\23",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | RULE_WS | RULE_SL_COMMENT | RULE_EOL | RULE_RAWTEXT | RULE_WORD );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_71 = input.LA(1);

                        s = -1;
                        if ( ((LA7_71>='\u0000' && LA7_71<='\b')||(LA7_71>='\u000B' && LA7_71<='\f')||(LA7_71>='\u000E' && LA7_71<='\u001F')||(LA7_71>='!' && LA7_71<='\uFFFF')) ) {s = 19;}

                        else s = 81;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_60 = input.LA(1);

                        s = -1;
                        if ( ((LA7_60>='\u0000' && LA7_60<='\b')||(LA7_60>='\u000B' && LA7_60<='\f')||(LA7_60>='\u000E' && LA7_60<='\u001F')||(LA7_60>='!' && LA7_60<='\uFFFF')) ) {s = 19;}

                        else s = 72;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_61 = input.LA(1);

                        s = -1;
                        if ( ((LA7_61>='\u0000' && LA7_61<='\b')||(LA7_61>='\u000B' && LA7_61<='\f')||(LA7_61>='\u000E' && LA7_61<='\u001F')||(LA7_61>='!' && LA7_61<='\uFFFF')) ) {s = 19;}

                        else s = 73;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA7_49 = input.LA(1);

                        s = -1;
                        if ( ((LA7_49>='\u0000' && LA7_49<='\b')||(LA7_49>='\u000B' && LA7_49<='\f')||(LA7_49>='\u000E' && LA7_49<='\u001F')||(LA7_49>='!' && LA7_49<='\uFFFF')) ) {s = 19;}

                        else s = 62;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA7_43 = input.LA(1);

                        s = -1;
                        if ( ((LA7_43>='\u0000' && LA7_43<='\b')||(LA7_43>='\u000B' && LA7_43<='\f')||(LA7_43>='\u000E' && LA7_43<='\u001F')||(LA7_43>='!' && LA7_43<='\uFFFF')) ) {s = 19;}

                        else s = 56;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA7_13 = input.LA(1);

                        s = -1;
                        if ( ((LA7_13>='\u0000' && LA7_13<='\b')||(LA7_13>='\u000B' && LA7_13<='\f')||(LA7_13>='\u000E' && LA7_13<='\u001F')||(LA7_13>='!' && LA7_13<='\uFFFF')) ) {s = 19;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA7_82 = input.LA(1);

                        s = -1;
                        if ( ((LA7_82>='\u0000' && LA7_82<='\b')||(LA7_82>='\u000B' && LA7_82<='\f')||(LA7_82>='\u000E' && LA7_82<='\u001F')||(LA7_82>='!' && LA7_82<='\uFFFF')) ) {s = 19;}

                        else s = 89;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA7_14 = input.LA(1);

                        s = -1;
                        if ( ((LA7_14>='\u0000' && LA7_14<='\b')||(LA7_14>='\u000B' && LA7_14<='\f')||(LA7_14>='\u000E' && LA7_14<='\u001F')||(LA7_14>='!' && LA7_14<='\uFFFF')) ) {s = 19;}

                        else s = 34;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA7_108 = input.LA(1);

                        s = -1;
                        if ( ((LA7_108>='\u0000' && LA7_108<='\b')||(LA7_108>='\u000B' && LA7_108<='\f')||(LA7_108>='\u000E' && LA7_108<='\u001F')||(LA7_108>='!' && LA7_108<='\uFFFF')) ) {s = 19;}

                        else s = 111;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA7_16 = input.LA(1);

                        s = -1;
                        if ( ((LA7_16>='\u0000' && LA7_16<='\b')||(LA7_16>='\u000B' && LA7_16<='\f')||(LA7_16>='\u000E' && LA7_16<='\u001F')||(LA7_16>='!' && LA7_16<='\uFFFF')) ) {s = 35;}

                        else if ( ((LA7_16>='\t' && LA7_16<='\n')||LA7_16=='\r'||LA7_16==' ') ) {s = 36;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA7_109 = input.LA(1);

                        s = -1;
                        if ( ((LA7_109>='\u0000' && LA7_109<='\b')||(LA7_109>='\u000B' && LA7_109<='\f')||(LA7_109>='\u000E' && LA7_109<='\u001F')||(LA7_109>='!' && LA7_109<='\uFFFF')) ) {s = 19;}

                        else s = 112;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA7_92 = input.LA(1);

                        s = -1;
                        if ( ((LA7_92>='\u0000' && LA7_92<='\b')||(LA7_92>='\u000B' && LA7_92<='\f')||(LA7_92>='\u000E' && LA7_92<='\u001F')||(LA7_92>='!' && LA7_92<='\uFFFF')) ) {s = 19;}

                        else s = 98;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA7_110 = input.LA(1);

                        s = -1;
                        if ( ((LA7_110>='\u0000' && LA7_110<='\b')||(LA7_110>='\u000B' && LA7_110<='\f')||(LA7_110>='\u000E' && LA7_110<='\u001F')||(LA7_110>='!' && LA7_110<='\uFFFF')) ) {s = 19;}

                        else s = 113;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA7_100 = input.LA(1);

                        s = -1;
                        if ( ((LA7_100>='\u0000' && LA7_100<='\b')||(LA7_100>='\u000B' && LA7_100<='\f')||(LA7_100>='\u000E' && LA7_100<='\u001F')||(LA7_100>='!' && LA7_100<='\uFFFF')) ) {s = 19;}

                        else s = 106;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA7_0 = input.LA(1);

                        s = -1;
                        if ( (LA7_0=='O') ) {s = 1;}

                        else if ( (LA7_0=='D') ) {s = 2;}

                        else if ( (LA7_0=='P') ) {s = 3;}

                        else if ( (LA7_0=='F') ) {s = 4;}

                        else if ( (LA7_0=='B') ) {s = 5;}

                        else if ( (LA7_0=='S') ) {s = 6;}

                        else if ( (LA7_0=='E') ) {s = 7;}

                        else if ( (LA7_0=='|') ) {s = 8;}

                        else if ( (LA7_0=='G') ) {s = 9;}

                        else if ( (LA7_0=='W') ) {s = 10;}

                        else if ( (LA7_0=='T') ) {s = 11;}

                        else if ( (LA7_0=='A') ) {s = 12;}

                        else if ( (LA7_0=='*') ) {s = 13;}

                        else if ( (LA7_0=='@') ) {s = 14;}

                        else if ( (LA7_0=='\t'||LA7_0=='\r'||LA7_0==' ') ) {s = 15;}

                        else if ( (LA7_0=='#') ) {s = 16;}

                        else if ( (LA7_0=='\n') ) {s = 17;}

                        else if ( (LA7_0=='\"') ) {s = 18;}

                        else if ( ((LA7_0>='\u0000' && LA7_0<='\b')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\u001F')||LA7_0=='!'||(LA7_0>='$' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='?')||LA7_0=='C'||(LA7_0>='H' && LA7_0<='N')||(LA7_0>='Q' && LA7_0<='R')||(LA7_0>='U' && LA7_0<='V')||(LA7_0>='X' && LA7_0<='{')||(LA7_0>='}' && LA7_0<='\uFFFF')) ) {s = 19;}

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA7_35 = input.LA(1);

                        s = -1;
                        if ( ((LA7_35>='\t' && LA7_35<='\n')||LA7_35=='\r'||LA7_35==' ') ) {s = 36;}

                        else if ( ((LA7_35>='\u0000' && LA7_35<='\b')||(LA7_35>='\u000B' && LA7_35<='\f')||(LA7_35>='\u000E' && LA7_35<='\u001F')||(LA7_35>='!' && LA7_35<='\uFFFF')) ) {s = 35;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA7_102 = input.LA(1);

                        s = -1;
                        if ( ((LA7_102>='\u0000' && LA7_102<='\b')||(LA7_102>='\u000B' && LA7_102<='\f')||(LA7_102>='\u000E' && LA7_102<='\u001F')||(LA7_102>='!' && LA7_102<='\uFFFF')) ) {s = 19;}

                        else s = 107;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA7_8 = input.LA(1);

                        s = -1;
                        if ( ((LA7_8>='\u0000' && LA7_8<='\b')||(LA7_8>='\u000B' && LA7_8<='\f')||(LA7_8>='\u000E' && LA7_8<='\u001F')||(LA7_8>='!' && LA7_8<='\uFFFF')) ) {s = 19;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}