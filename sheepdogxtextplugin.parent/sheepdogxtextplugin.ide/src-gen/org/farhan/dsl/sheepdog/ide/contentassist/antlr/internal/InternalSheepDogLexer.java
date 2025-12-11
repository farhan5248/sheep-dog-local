package org.farhan.dsl.sheepdog.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSheepDogLexer extends Lexer {
    public static final int RULE_WORD=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__10=10;
    public static final int T__32=32;
    public static final int T__9=9;
    public static final int RULE_EOL=5;
    public static final int RULE_WS=7;
    public static final int RULE_RAWTEXT=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalSheepDogLexer() {;} 
    public InternalSheepDogLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalSheepDogLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalSheepDog.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:11:6: ( 'file' )
            // InternalSheepDog.g:11:8: 'file'
            {
            match("file"); 


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
            // InternalSheepDog.g:12:7: ( 'page' )
            // InternalSheepDog.g:12:9: 'page'
            {
            match("page"); 


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
            // InternalSheepDog.g:13:7: ( 'response' )
            // InternalSheepDog.g:13:9: 'response'
            {
            match("response"); 


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
            // InternalSheepDog.g:14:7: ( 'dialog' )
            // InternalSheepDog.g:14:9: 'dialog'
            {
            match("dialog"); 


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
            // InternalSheepDog.g:15:7: ( 'directory' )
            // InternalSheepDog.g:15:9: 'directory'
            {
            match("directory"); 


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
            // InternalSheepDog.g:16:7: ( 'request' )
            // InternalSheepDog.g:16:9: 'request'
            {
            match("request"); 


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
            // InternalSheepDog.g:17:7: ( 'goal' )
            // InternalSheepDog.g:17:9: 'goal'
            {
            match("goal"); 


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
            // InternalSheepDog.g:18:7: ( 'job' )
            // InternalSheepDog.g:18:9: 'job'
            {
            match("job"); 


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
            // InternalSheepDog.g:19:7: ( 'action' )
            // InternalSheepDog.g:19:9: 'action'
            {
            match("action"); 


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
            // InternalSheepDog.g:20:7: ( '=' )
            // InternalSheepDog.g:20:9: '='
            {
            match('='); 

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
            // InternalSheepDog.g:21:7: ( 'Step-Object:' )
            // InternalSheepDog.g:21:9: 'Step-Object:'
            {
            match("Step-Object:"); 


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
            // InternalSheepDog.g:22:7: ( '==' )
            // InternalSheepDog.g:22:9: '=='
            {
            match("=="); 


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
            // InternalSheepDog.g:23:7: ( 'Step-Definition:' )
            // InternalSheepDog.g:23:9: 'Step-Definition:'
            {
            match("Step-Definition:"); 


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
            // InternalSheepDog.g:24:7: ( '*' )
            // InternalSheepDog.g:24:9: '*'
            {
            match('*'); 

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
            // InternalSheepDog.g:25:7: ( 'Step-Parameters:' )
            // InternalSheepDog.g:25:9: 'Step-Parameters:'
            {
            match("Step-Parameters:"); 


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
            // InternalSheepDog.g:26:7: ( 'Test-Suite:' )
            // InternalSheepDog.g:26:9: 'Test-Suite:'
            {
            match("Test-Suite:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:27:7: ( 'Test-Setup:' )
            // InternalSheepDog.g:27:9: 'Test-Setup:'
            {
            match("Test-Setup:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:28:7: ( 'Test-Case:' )
            // InternalSheepDog.g:28:9: 'Test-Case:'
            {
            match("Test-Case:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:29:7: ( 'Test-Data:' )
            // InternalSheepDog.g:29:9: 'Test-Data:'
            {
            match("Test-Data:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:30:7: ( 'Given:' )
            // InternalSheepDog.g:30:9: 'Given:'
            {
            match("Given:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:31:7: ( 'When:' )
            // InternalSheepDog.g:31:9: 'When:'
            {
            match("When:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:32:7: ( 'Then:' )
            // InternalSheepDog.g:32:9: 'Then:'
            {
            match("Then:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:33:7: ( 'And:' )
            // InternalSheepDog.g:33:9: 'And:'
            {
            match("And:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:34:7: ( '+' )
            // InternalSheepDog.g:34:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:35:7: ( '|===' )
            // InternalSheepDog.g:35:9: '|==='
            {
            match("|==="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:36:7: ( '|' )
            // InternalSheepDog.g:36:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "RULE_WORD"
    public final void mRULE_WORD() throws RecognitionException {
        try {
            int _type = RULE_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:3954:11: (~ ( ( ' ' | '\\t' | '\\r' | '\\n' | '|' | '#' ) ) (~ ( ( ' ' | '\\t' | '\\r' | '\\n' ) ) )* )
            // InternalSheepDog.g:3954:13: ~ ( ( ' ' | '\\t' | '\\r' | '\\n' | '|' | '#' ) ) (~ ( ( ' ' | '\\t' | '\\r' | '\\n' ) ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||(input.LA(1)>='$' && input.LA(1)<='{')||(input.LA(1)>='}' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalSheepDog.g:3954:45: (~ ( ( ' ' | '\\t' | '\\r' | '\\n' ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\b')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\u001F')||(LA1_0>='!' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSheepDog.g:3954:45: ~ ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
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
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WORD"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSheepDog.g:3956:9: ( ( ' ' | '\\t' | '\\r' )+ )
            // InternalSheepDog.g:3956:11: ( ' ' | '\\t' | '\\r' )+
            {
            // InternalSheepDog.g:3956:11: ( ' ' | '\\t' | '\\r' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\t'||LA2_0=='\r'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSheepDog.g:
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
            // InternalSheepDog.g:3958:17: ( '#' (~ ( '\\n' ) )* RULE_EOL )
            // InternalSheepDog.g:3958:19: '#' (~ ( '\\n' ) )* RULE_EOL
            {
            match('#'); 
            // InternalSheepDog.g:3958:23: (~ ( '\\n' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSheepDog.g:3958:23: ~ ( '\\n' )
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
            	    break loop3;
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
            // InternalSheepDog.g:3960:10: ( ( '\\n' )+ )
            // InternalSheepDog.g:3960:12: ( '\\n' )+
            {
            // InternalSheepDog.g:3960:12: ( '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\n') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSheepDog.g:3960:12: '\\n'
            	    {
            	    match('\n'); 

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
            // InternalSheepDog.g:3962:14: ( '----' '\\n' ( . )+ '\\n' '----' )
            // InternalSheepDog.g:3962:16: '----' '\\n' ( . )+ '\\n' '----'
            {
            match("----"); 

            match('\n'); 
            // InternalSheepDog.g:3962:28: ( . )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\n') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='-') ) {
                        int LA5_3 = input.LA(3);

                        if ( (LA5_3=='-') ) {
                            int LA5_4 = input.LA(4);

                            if ( (LA5_4=='-') ) {
                                int LA5_5 = input.LA(5);

                                if ( (LA5_5=='-') ) {
                                    alt5=2;
                                }
                                else if ( ((LA5_5>='\u0000' && LA5_5<=',')||(LA5_5>='.' && LA5_5<='\uFFFF')) ) {
                                    alt5=1;
                                }


                            }
                            else if ( ((LA5_4>='\u0000' && LA5_4<=',')||(LA5_4>='.' && LA5_4<='\uFFFF')) ) {
                                alt5=1;
                            }


                        }
                        else if ( ((LA5_3>='\u0000' && LA5_3<=',')||(LA5_3>='.' && LA5_3<='\uFFFF')) ) {
                            alt5=1;
                        }


                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<=',')||(LA5_1>='.' && LA5_1<='\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSheepDog.g:3962:28: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            match('\n'); 
            match("----"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RAWTEXT"

    public void mTokens() throws RecognitionException {
        // InternalSheepDog.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | RULE_WORD | RULE_WS | RULE_SL_COMMENT | RULE_EOL | RULE_RAWTEXT )
        int alt6=31;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // InternalSheepDog.g:1:10: T__9
                {
                mT__9(); 

                }
                break;
            case 2 :
                // InternalSheepDog.g:1:15: T__10
                {
                mT__10(); 

                }
                break;
            case 3 :
                // InternalSheepDog.g:1:21: T__11
                {
                mT__11(); 

                }
                break;
            case 4 :
                // InternalSheepDog.g:1:27: T__12
                {
                mT__12(); 

                }
                break;
            case 5 :
                // InternalSheepDog.g:1:33: T__13
                {
                mT__13(); 

                }
                break;
            case 6 :
                // InternalSheepDog.g:1:39: T__14
                {
                mT__14(); 

                }
                break;
            case 7 :
                // InternalSheepDog.g:1:45: T__15
                {
                mT__15(); 

                }
                break;
            case 8 :
                // InternalSheepDog.g:1:51: T__16
                {
                mT__16(); 

                }
                break;
            case 9 :
                // InternalSheepDog.g:1:57: T__17
                {
                mT__17(); 

                }
                break;
            case 10 :
                // InternalSheepDog.g:1:63: T__18
                {
                mT__18(); 

                }
                break;
            case 11 :
                // InternalSheepDog.g:1:69: T__19
                {
                mT__19(); 

                }
                break;
            case 12 :
                // InternalSheepDog.g:1:75: T__20
                {
                mT__20(); 

                }
                break;
            case 13 :
                // InternalSheepDog.g:1:81: T__21
                {
                mT__21(); 

                }
                break;
            case 14 :
                // InternalSheepDog.g:1:87: T__22
                {
                mT__22(); 

                }
                break;
            case 15 :
                // InternalSheepDog.g:1:93: T__23
                {
                mT__23(); 

                }
                break;
            case 16 :
                // InternalSheepDog.g:1:99: T__24
                {
                mT__24(); 

                }
                break;
            case 17 :
                // InternalSheepDog.g:1:105: T__25
                {
                mT__25(); 

                }
                break;
            case 18 :
                // InternalSheepDog.g:1:111: T__26
                {
                mT__26(); 

                }
                break;
            case 19 :
                // InternalSheepDog.g:1:117: T__27
                {
                mT__27(); 

                }
                break;
            case 20 :
                // InternalSheepDog.g:1:123: T__28
                {
                mT__28(); 

                }
                break;
            case 21 :
                // InternalSheepDog.g:1:129: T__29
                {
                mT__29(); 

                }
                break;
            case 22 :
                // InternalSheepDog.g:1:135: T__30
                {
                mT__30(); 

                }
                break;
            case 23 :
                // InternalSheepDog.g:1:141: T__31
                {
                mT__31(); 

                }
                break;
            case 24 :
                // InternalSheepDog.g:1:147: T__32
                {
                mT__32(); 

                }
                break;
            case 25 :
                // InternalSheepDog.g:1:153: T__33
                {
                mT__33(); 

                }
                break;
            case 26 :
                // InternalSheepDog.g:1:159: T__34
                {
                mT__34(); 

                }
                break;
            case 27 :
                // InternalSheepDog.g:1:165: RULE_WORD
                {
                mRULE_WORD(); 

                }
                break;
            case 28 :
                // InternalSheepDog.g:1:175: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 29 :
                // InternalSheepDog.g:1:183: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 30 :
                // InternalSheepDog.g:1:199: RULE_EOL
                {
                mRULE_EOL(); 

                }
                break;
            case 31 :
                // InternalSheepDog.g:1:208: RULE_RAWTEXT
                {
                mRULE_RAWTEXT(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\7\25\1\36\1\25\1\40\4\25\1\46\1\50\1\25\4\uffff\7\25\1\63\1\uffff\1\25\1\uffff\5\25\3\uffff\10\25\1\102\1\25\1\uffff\7\25\1\113\1\114\4\25\1\121\1\uffff\6\25\1\130\1\25\2\uffff\4\25\1\uffff\3\25\1\145\1\25\1\147\2\uffff\2\25\1\152\1\25\1\154\6\25\1\uffff\1\164\1\uffff\1\25\1\166\1\uffff\1\25\1\uffff\7\25\1\uffff\1\177\1\uffff\10\25\1\uffff\1\u0088\7\25\1\uffff\5\25\1\u0095\1\u0096\3\25\1\u009a\1\u009b\2\uffff\1\u009c\2\25\3\uffff\6\25\1\u00a5\1\u00a6\2\uffff";
    static final String DFA6_eofS =
        "\u00a7\uffff";
    static final String DFA6_minS =
        "\1\0\1\151\1\141\1\145\1\151\2\157\1\143\1\0\1\164\1\0\1\145\1\151\1\150\1\156\1\0\1\75\1\55\4\uffff\1\154\1\147\1\161\2\141\1\142\1\164\1\0\1\uffff\1\145\1\uffff\1\163\1\145\1\166\1\145\1\144\3\uffff\1\55\2\145\1\160\1\165\1\154\1\145\1\154\1\0\1\151\1\uffff\1\160\1\164\1\156\1\145\1\156\1\72\1\55\2\0\1\157\1\145\1\157\1\143\1\0\1\uffff\1\157\2\55\1\72\1\156\1\72\1\0\1\12\2\uffff\1\156\1\163\1\147\1\164\1\uffff\1\156\1\104\1\103\1\0\1\72\1\0\2\uffff\1\163\1\164\1\0\1\157\1\0\1\142\1\145\1\141\1\145\2\141\1\uffff\1\0\1\uffff\1\145\1\0\1\uffff\1\162\1\uffff\1\152\1\146\1\162\1\151\1\164\1\163\1\164\1\uffff\1\0\1\uffff\1\171\1\145\1\151\1\141\1\164\1\165\1\145\1\141\1\uffff\1\0\1\143\1\156\1\155\1\145\1\160\2\72\1\uffff\1\164\1\151\1\145\2\72\2\0\1\72\2\164\2\0\2\uffff\1\0\1\151\1\145\3\uffff\1\157\1\162\1\156\1\163\2\72\2\0\2\uffff";
    static final String DFA6_maxS =
        "\1\uffff\1\151\1\141\1\145\1\151\2\157\1\143\1\uffff\1\164\1\uffff\1\150\1\151\1\150\1\156\1\uffff\1\75\1\55\4\uffff\1\154\1\147\1\163\1\162\1\141\1\142\1\164\1\uffff\1\uffff\1\145\1\uffff\1\163\1\145\1\166\1\145\1\144\3\uffff\1\55\2\145\1\160\1\165\1\154\1\145\1\154\1\uffff\1\151\1\uffff\1\160\1\164\1\156\1\145\1\156\1\72\1\55\2\uffff\1\157\1\145\1\157\1\143\1\uffff\1\uffff\1\157\2\55\1\72\1\156\1\72\1\uffff\1\12\2\uffff\1\156\1\163\1\147\1\164\1\uffff\1\156\1\120\1\123\1\uffff\1\72\1\uffff\2\uffff\1\163\1\164\1\uffff\1\157\1\uffff\1\142\1\145\1\141\1\165\2\141\1\uffff\1\uffff\1\uffff\1\145\1\uffff\1\uffff\1\162\1\uffff\1\152\1\146\1\162\1\151\1\164\1\163\1\164\1\uffff\1\uffff\1\uffff\1\171\1\145\1\151\1\141\1\164\1\165\1\145\1\141\1\uffff\1\uffff\1\143\1\156\1\155\1\145\1\160\2\72\1\uffff\1\164\1\151\1\145\2\72\2\uffff\1\72\2\164\2\uffff\2\uffff\1\uffff\1\151\1\145\3\uffff\1\157\1\162\1\156\1\163\2\72\2\uffff\2\uffff";
    static final String DFA6_acceptS =
        "\22\uffff\1\34\1\35\1\36\1\33\10\uffff\1\12\1\uffff\1\16\5\uffff\1\30\1\31\1\32\12\uffff\1\14\16\uffff\1\10\10\uffff\1\1\1\2\4\uffff\1\7\6\uffff\1\27\1\37\13\uffff\1\26\1\uffff\1\25\2\uffff\1\4\1\uffff\1\11\7\uffff\1\24\1\uffff\1\6\10\uffff\1\3\10\uffff\1\5\14\uffff\1\22\1\23\3\uffff\1\20\1\21\1\13\10\uffff\1\15\1\17";
    static final String DFA6_specialS =
        "\1\27\7\uffff\1\4\1\uffff\1\23\4\uffff\1\13\15\uffff\1\5\23\uffff\1\30\11\uffff\1\10\1\11\4\uffff\1\25\7\uffff\1\2\13\uffff\1\0\1\uffff\1\26\4\uffff\1\16\1\uffff\1\1\7\uffff\1\24\2\uffff\1\22\13\uffff\1\14\12\uffff\1\20\15\uffff\1\17\1\21\3\uffff\1\12\1\15\2\uffff\1\3\13\uffff\1\6\1\7\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\11\25\1\22\1\24\2\25\1\22\22\25\1\22\2\25\1\23\6\25\1\12\1\17\1\25\1\21\17\25\1\10\3\25\1\16\5\25\1\14\13\25\1\11\1\13\2\25\1\15\11\25\1\7\2\25\1\4\1\25\1\1\1\5\2\25\1\6\5\25\1\2\1\25\1\3\11\25\1\20\uff83\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\34\25\1\35\uffc2\25",
            "\1\37",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\41\2\uffff\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\47",
            "\1\51",
            "",
            "",
            "",
            "",
            "\1\52",
            "\1\53",
            "\1\55\1\uffff\1\54",
            "\1\56\20\uffff\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "",
            "\1\64",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "",
            "",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\103",
            "",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\131",
            "",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "",
            "\1\136",
            "\1\140\12\uffff\1\137\1\141",
            "\1\143\1\144\16\uffff\1\142",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\146",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "",
            "",
            "\1\150",
            "\1\151",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\153",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\161\17\uffff\1\160",
            "\1\162",
            "\1\163",
            "",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "",
            "\1\165",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "",
            "\1\167",
            "",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "",
            "",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\1\u009d",
            "\1\u009e",
            "",
            "",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\uffdf\25",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | RULE_WORD | RULE_WS | RULE_SL_COMMENT | RULE_EOL | RULE_RAWTEXT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_85 = input.LA(1);

                        s = -1;
                        if ( ((LA6_85>='\u0000' && LA6_85<='\b')||(LA6_85>='\u000B' && LA6_85<='\f')||(LA6_85>='\u000E' && LA6_85<='\u001F')||(LA6_85>='!' && LA6_85<='\uFFFF')) ) {s = 21;}

                        else s = 101;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_94 = input.LA(1);

                        s = -1;
                        if ( ((LA6_94>='\u0000' && LA6_94<='\b')||(LA6_94>='\u000B' && LA6_94<='\f')||(LA6_94>='\u000E' && LA6_94<='\u001F')||(LA6_94>='!' && LA6_94<='\uFFFF')) ) {s = 21;}

                        else s = 108;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_73 = input.LA(1);

                        s = -1;
                        if ( ((LA6_73>='\u0000' && LA6_73<='\b')||(LA6_73>='\u000B' && LA6_73<='\f')||(LA6_73>='\u000E' && LA6_73<='\u001F')||(LA6_73>='!' && LA6_73<='\uFFFF')) ) {s = 21;}

                        else s = 88;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_151 = input.LA(1);

                        s = -1;
                        if ( ((LA6_151>='\u0000' && LA6_151<='\b')||(LA6_151>='\u000B' && LA6_151<='\f')||(LA6_151>='\u000E' && LA6_151<='\u001F')||(LA6_151>='!' && LA6_151<='\uFFFF')) ) {s = 21;}

                        else s = 156;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_8 = input.LA(1);

                        s = -1;
                        if ( (LA6_8=='=') ) {s = 29;}

                        else if ( ((LA6_8>='\u0000' && LA6_8<='\b')||(LA6_8>='\u000B' && LA6_8<='\f')||(LA6_8>='\u000E' && LA6_8<='\u001F')||(LA6_8>='!' && LA6_8<='<')||(LA6_8>='>' && LA6_8<='\uFFFF')) ) {s = 21;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_29 = input.LA(1);

                        s = -1;
                        if ( ((LA6_29>='\u0000' && LA6_29<='\b')||(LA6_29>='\u000B' && LA6_29<='\f')||(LA6_29>='\u000E' && LA6_29<='\u001F')||(LA6_29>='!' && LA6_29<='\uFFFF')) ) {s = 21;}

                        else s = 51;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_163 = input.LA(1);

                        s = -1;
                        if ( ((LA6_163>='\u0000' && LA6_163<='\b')||(LA6_163>='\u000B' && LA6_163<='\f')||(LA6_163>='\u000E' && LA6_163<='\u001F')||(LA6_163>='!' && LA6_163<='\uFFFF')) ) {s = 21;}

                        else s = 165;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_164 = input.LA(1);

                        s = -1;
                        if ( ((LA6_164>='\u0000' && LA6_164<='\b')||(LA6_164>='\u000B' && LA6_164<='\f')||(LA6_164>='\u000E' && LA6_164<='\u001F')||(LA6_164>='!' && LA6_164<='\uFFFF')) ) {s = 21;}

                        else s = 166;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_59 = input.LA(1);

                        s = -1;
                        if ( ((LA6_59>='\u0000' && LA6_59<='\b')||(LA6_59>='\u000B' && LA6_59<='\f')||(LA6_59>='\u000E' && LA6_59<='\u001F')||(LA6_59>='!' && LA6_59<='\uFFFF')) ) {s = 21;}

                        else s = 75;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_60 = input.LA(1);

                        s = -1;
                        if ( ((LA6_60>='\u0000' && LA6_60<='\b')||(LA6_60>='\u000B' && LA6_60<='\f')||(LA6_60>='\u000E' && LA6_60<='\u001F')||(LA6_60>='!' && LA6_60<='\uFFFF')) ) {s = 21;}

                        else s = 76;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_147 = input.LA(1);

                        s = -1;
                        if ( ((LA6_147>='\u0000' && LA6_147<='\b')||(LA6_147>='\u000B' && LA6_147<='\f')||(LA6_147>='\u000E' && LA6_147<='\u001F')||(LA6_147>='!' && LA6_147<='\uFFFF')) ) {s = 21;}

                        else s = 154;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_15 = input.LA(1);

                        s = -1;
                        if ( ((LA6_15>='\u0000' && LA6_15<='\b')||(LA6_15>='\u000B' && LA6_15<='\f')||(LA6_15>='\u000E' && LA6_15<='\u001F')||(LA6_15>='!' && LA6_15<='\uFFFF')) ) {s = 21;}

                        else s = 38;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_117 = input.LA(1);

                        s = -1;
                        if ( ((LA6_117>='\u0000' && LA6_117<='\b')||(LA6_117>='\u000B' && LA6_117<='\f')||(LA6_117>='\u000E' && LA6_117<='\u001F')||(LA6_117>='!' && LA6_117<='\uFFFF')) ) {s = 21;}

                        else s = 127;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA6_148 = input.LA(1);

                        s = -1;
                        if ( ((LA6_148>='\u0000' && LA6_148<='\b')||(LA6_148>='\u000B' && LA6_148<='\f')||(LA6_148>='\u000E' && LA6_148<='\u001F')||(LA6_148>='!' && LA6_148<='\uFFFF')) ) {s = 21;}

                        else s = 155;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA6_92 = input.LA(1);

                        s = -1;
                        if ( ((LA6_92>='\u0000' && LA6_92<='\b')||(LA6_92>='\u000B' && LA6_92<='\f')||(LA6_92>='\u000E' && LA6_92<='\u001F')||(LA6_92>='!' && LA6_92<='\uFFFF')) ) {s = 21;}

                        else s = 106;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA6_142 = input.LA(1);

                        s = -1;
                        if ( ((LA6_142>='\u0000' && LA6_142<='\b')||(LA6_142>='\u000B' && LA6_142<='\f')||(LA6_142>='\u000E' && LA6_142<='\u001F')||(LA6_142>='!' && LA6_142<='\uFFFF')) ) {s = 21;}

                        else s = 149;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA6_128 = input.LA(1);

                        s = -1;
                        if ( ((LA6_128>='\u0000' && LA6_128<='\b')||(LA6_128>='\u000B' && LA6_128<='\f')||(LA6_128>='\u000E' && LA6_128<='\u001F')||(LA6_128>='!' && LA6_128<='\uFFFF')) ) {s = 21;}

                        else s = 136;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA6_143 = input.LA(1);

                        s = -1;
                        if ( ((LA6_143>='\u0000' && LA6_143<='\b')||(LA6_143>='\u000B' && LA6_143<='\f')||(LA6_143>='\u000E' && LA6_143<='\u001F')||(LA6_143>='!' && LA6_143<='\uFFFF')) ) {s = 21;}

                        else s = 150;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA6_105 = input.LA(1);

                        s = -1;
                        if ( ((LA6_105>='\u0000' && LA6_105<='\b')||(LA6_105>='\u000B' && LA6_105<='\f')||(LA6_105>='\u000E' && LA6_105<='\u001F')||(LA6_105>='!' && LA6_105<='\uFFFF')) ) {s = 21;}

                        else s = 118;

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA6_10 = input.LA(1);

                        s = -1;
                        if ( ((LA6_10>='\u0000' && LA6_10<='\b')||(LA6_10>='\u000B' && LA6_10<='\f')||(LA6_10>='\u000E' && LA6_10<='\u001F')||(LA6_10>='!' && LA6_10<='\uFFFF')) ) {s = 21;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA6_102 = input.LA(1);

                        s = -1;
                        if ( ((LA6_102>='\u0000' && LA6_102<='\b')||(LA6_102>='\u000B' && LA6_102<='\f')||(LA6_102>='\u000E' && LA6_102<='\u001F')||(LA6_102>='!' && LA6_102<='\uFFFF')) ) {s = 21;}

                        else s = 116;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA6_65 = input.LA(1);

                        s = -1;
                        if ( ((LA6_65>='\u0000' && LA6_65<='\b')||(LA6_65>='\u000B' && LA6_65<='\f')||(LA6_65>='\u000E' && LA6_65<='\u001F')||(LA6_65>='!' && LA6_65<='\uFFFF')) ) {s = 21;}

                        else s = 81;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA6_87 = input.LA(1);

                        s = -1;
                        if ( ((LA6_87>='\u0000' && LA6_87<='\b')||(LA6_87>='\u000B' && LA6_87<='\f')||(LA6_87>='\u000E' && LA6_87<='\u001F')||(LA6_87>='!' && LA6_87<='\uFFFF')) ) {s = 21;}

                        else s = 103;

                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA6_0 = input.LA(1);

                        s = -1;
                        if ( (LA6_0=='f') ) {s = 1;}

                        else if ( (LA6_0=='p') ) {s = 2;}

                        else if ( (LA6_0=='r') ) {s = 3;}

                        else if ( (LA6_0=='d') ) {s = 4;}

                        else if ( (LA6_0=='g') ) {s = 5;}

                        else if ( (LA6_0=='j') ) {s = 6;}

                        else if ( (LA6_0=='a') ) {s = 7;}

                        else if ( (LA6_0=='=') ) {s = 8;}

                        else if ( (LA6_0=='S') ) {s = 9;}

                        else if ( (LA6_0=='*') ) {s = 10;}

                        else if ( (LA6_0=='T') ) {s = 11;}

                        else if ( (LA6_0=='G') ) {s = 12;}

                        else if ( (LA6_0=='W') ) {s = 13;}

                        else if ( (LA6_0=='A') ) {s = 14;}

                        else if ( (LA6_0=='+') ) {s = 15;}

                        else if ( (LA6_0=='|') ) {s = 16;}

                        else if ( (LA6_0=='-') ) {s = 17;}

                        else if ( (LA6_0=='\t'||LA6_0=='\r'||LA6_0==' ') ) {s = 18;}

                        else if ( (LA6_0=='#') ) {s = 19;}

                        else if ( (LA6_0=='\n') ) {s = 20;}

                        else if ( ((LA6_0>='\u0000' && LA6_0<='\b')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\u001F')||(LA6_0>='!' && LA6_0<='\"')||(LA6_0>='$' && LA6_0<=')')||LA6_0==','||(LA6_0>='.' && LA6_0<='<')||(LA6_0>='>' && LA6_0<='@')||(LA6_0>='B' && LA6_0<='F')||(LA6_0>='H' && LA6_0<='R')||(LA6_0>='U' && LA6_0<='V')||(LA6_0>='X' && LA6_0<='`')||(LA6_0>='b' && LA6_0<='c')||LA6_0=='e'||(LA6_0>='h' && LA6_0<='i')||(LA6_0>='k' && LA6_0<='o')||LA6_0=='q'||(LA6_0>='s' && LA6_0<='{')||(LA6_0>='}' && LA6_0<='\uFFFF')) ) {s = 21;}

                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA6_49 = input.LA(1);

                        s = -1;
                        if ( ((LA6_49>='\u0000' && LA6_49<='\b')||(LA6_49>='\u000B' && LA6_49<='\f')||(LA6_49>='\u000E' && LA6_49<='\u001F')||(LA6_49>='!' && LA6_49<='\uFFFF')) ) {s = 21;}

                        else s = 66;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}