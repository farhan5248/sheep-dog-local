package org.farhan.dsl.cucumber.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCucumberParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_EOL", "RULE_RAWTEXT", "RULE_WORD", "RULE_WS", "RULE_SL_COMMENT", "'Object:'", "'Definition:'", "'Parameters:'", "'Feature:'", "'Background:'", "'Scenario:'", "'Scenario Outline:'", "'Examples:'", "'|'", "'Given'", "'When'", "'Then'", "'And'", "'But'", "'*'", "'@'"
    };
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


        public InternalCucumberParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCucumberParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCucumberParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCucumber.g"; }



     	private CucumberGrammarAccess grammarAccess;

        public InternalCucumberParser(TokenStream input, CucumberGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected CucumberGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalCucumber.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalCucumber.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalCucumber.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalCucumber.g:71:1: ruleModel returns [EObject current=null] : (this_StepObject_0= ruleStepObject | this_Feature_1= ruleFeature ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_StepObject_0 = null;

        EObject this_Feature_1 = null;



        	enterRule();

        try {
            // InternalCucumber.g:77:2: ( (this_StepObject_0= ruleStepObject | this_Feature_1= ruleFeature ) )
            // InternalCucumber.g:78:2: (this_StepObject_0= ruleStepObject | this_Feature_1= ruleFeature )
            {
            // InternalCucumber.g:78:2: (this_StepObject_0= ruleStepObject | this_Feature_1= ruleFeature )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==9) ) {
                alt1=1;
            }
            else if ( (LA1_0==12||LA1_0==24) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalCucumber.g:79:3: this_StepObject_0= ruleStepObject
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getStepObjectParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StepObject_0=ruleStepObject();

                    state._fsp--;


                    			current = this_StepObject_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalCucumber.g:88:3: this_Feature_1= ruleFeature
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getFeatureParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Feature_1=ruleFeature();

                    state._fsp--;


                    			current = this_Feature_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleStepObject"
    // InternalCucumber.g:100:1: entryRuleStepObject returns [EObject current=null] : iv_ruleStepObject= ruleStepObject EOF ;
    public final EObject entryRuleStepObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepObject = null;


        try {
            // InternalCucumber.g:100:51: (iv_ruleStepObject= ruleStepObject EOF )
            // InternalCucumber.g:101:2: iv_ruleStepObject= ruleStepObject EOF
            {
             newCompositeNode(grammarAccess.getStepObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStepObject=ruleStepObject();

            state._fsp--;

             current =iv_ruleStepObject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStepObject"


    // $ANTLR start "ruleStepObject"
    // InternalCucumber.g:107:1: ruleStepObject returns [EObject current=null] : (otherlv_0= 'Object:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepDefinitions_4_0= ruleStepDefinition ) )* ) ;
    public final EObject ruleStepObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_statements_3_0 = null;

        EObject lv_stepDefinitions_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:113:2: ( (otherlv_0= 'Object:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepDefinitions_4_0= ruleStepDefinition ) )* ) )
            // InternalCucumber.g:114:2: (otherlv_0= 'Object:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepDefinitions_4_0= ruleStepDefinition ) )* )
            {
            // InternalCucumber.g:114:2: (otherlv_0= 'Object:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepDefinitions_4_0= ruleStepDefinition ) )* )
            // InternalCucumber.g:115:3: otherlv_0= 'Object:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepDefinitions_4_0= ruleStepDefinition ) )*
            {
            otherlv_0=(Token)match(input,9,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStepObjectAccess().getObjectKeyword_0());
            		
            // InternalCucumber.g:119:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:120:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:120:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:121:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getStepObjectAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepObjectRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_5); 

            			newLeafNode(this_EOL_2, grammarAccess.getStepObjectAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:142:3: ( (lv_statements_3_0= ruleStatement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_WORD) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCucumber.g:143:4: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalCucumber.g:143:4: (lv_statements_3_0= ruleStatement )
            	    // InternalCucumber.g:144:5: lv_statements_3_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getStepObjectAccess().getStatementsStatementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStepObjectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_3_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalCucumber.g:161:3: ( (lv_stepDefinitions_4_0= ruleStepDefinition ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCucumber.g:162:4: (lv_stepDefinitions_4_0= ruleStepDefinition )
            	    {
            	    // InternalCucumber.g:162:4: (lv_stepDefinitions_4_0= ruleStepDefinition )
            	    // InternalCucumber.g:163:5: lv_stepDefinitions_4_0= ruleStepDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getStepObjectAccess().getStepDefinitionsStepDefinitionParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_stepDefinitions_4_0=ruleStepDefinition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStepObjectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"stepDefinitions",
            	    						lv_stepDefinitions_4_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.StepDefinition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStepObject"


    // $ANTLR start "entryRuleStepDefinition"
    // InternalCucumber.g:184:1: entryRuleStepDefinition returns [EObject current=null] : iv_ruleStepDefinition= ruleStepDefinition EOF ;
    public final EObject entryRuleStepDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepDefinition = null;


        try {
            // InternalCucumber.g:184:55: (iv_ruleStepDefinition= ruleStepDefinition EOF )
            // InternalCucumber.g:185:2: iv_ruleStepDefinition= ruleStepDefinition EOF
            {
             newCompositeNode(grammarAccess.getStepDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStepDefinition=ruleStepDefinition();

            state._fsp--;

             current =iv_ruleStepDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStepDefinition"


    // $ANTLR start "ruleStepDefinition"
    // InternalCucumber.g:191:1: ruleStepDefinition returns [EObject current=null] : (otherlv_0= 'Definition:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepParameters_4_0= ruleStepParameters ) )* ) ;
    public final EObject ruleStepDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_statements_3_0 = null;

        EObject lv_stepParameters_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:197:2: ( (otherlv_0= 'Definition:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepParameters_4_0= ruleStepParameters ) )* ) )
            // InternalCucumber.g:198:2: (otherlv_0= 'Definition:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepParameters_4_0= ruleStepParameters ) )* )
            {
            // InternalCucumber.g:198:2: (otherlv_0= 'Definition:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepParameters_4_0= ruleStepParameters ) )* )
            // InternalCucumber.g:199:3: otherlv_0= 'Definition:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_stepParameters_4_0= ruleStepParameters ) )*
            {
            otherlv_0=(Token)match(input,10,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStepDefinitionAccess().getDefinitionKeyword_0());
            		
            // InternalCucumber.g:203:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:204:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:204:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:205:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getStepDefinitionAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepDefinitionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_7); 

            			newLeafNode(this_EOL_2, grammarAccess.getStepDefinitionAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:226:3: ( (lv_statements_3_0= ruleStatement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_WORD) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCucumber.g:227:4: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalCucumber.g:227:4: (lv_statements_3_0= ruleStatement )
            	    // InternalCucumber.g:228:5: lv_statements_3_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getStepDefinitionAccess().getStatementsStatementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStepDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_3_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalCucumber.g:245:3: ( (lv_stepParameters_4_0= ruleStepParameters ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==11) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalCucumber.g:246:4: (lv_stepParameters_4_0= ruleStepParameters )
            	    {
            	    // InternalCucumber.g:246:4: (lv_stepParameters_4_0= ruleStepParameters )
            	    // InternalCucumber.g:247:5: lv_stepParameters_4_0= ruleStepParameters
            	    {

            	    					newCompositeNode(grammarAccess.getStepDefinitionAccess().getStepParametersStepParametersParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_stepParameters_4_0=ruleStepParameters();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStepDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"stepParameters",
            	    						lv_stepParameters_4_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.StepParameters");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStepDefinition"


    // $ANTLR start "entryRuleStepParameters"
    // InternalCucumber.g:268:1: entryRuleStepParameters returns [EObject current=null] : iv_ruleStepParameters= ruleStepParameters EOF ;
    public final EObject entryRuleStepParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepParameters = null;


        try {
            // InternalCucumber.g:268:55: (iv_ruleStepParameters= ruleStepParameters EOF )
            // InternalCucumber.g:269:2: iv_ruleStepParameters= ruleStepParameters EOF
            {
             newCompositeNode(grammarAccess.getStepParametersRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStepParameters=ruleStepParameters();

            state._fsp--;

             current =iv_ruleStepParameters; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStepParameters"


    // $ANTLR start "ruleStepParameters"
    // InternalCucumber.g:275:1: ruleStepParameters returns [EObject current=null] : (otherlv_0= 'Parameters:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_parametersTable_4_0= ruleParametersTable ) ) ) ;
    public final EObject ruleStepParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_statements_3_0 = null;

        EObject lv_parametersTable_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:281:2: ( (otherlv_0= 'Parameters:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_parametersTable_4_0= ruleParametersTable ) ) ) )
            // InternalCucumber.g:282:2: (otherlv_0= 'Parameters:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_parametersTable_4_0= ruleParametersTable ) ) )
            {
            // InternalCucumber.g:282:2: (otherlv_0= 'Parameters:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_parametersTable_4_0= ruleParametersTable ) ) )
            // InternalCucumber.g:283:3: otherlv_0= 'Parameters:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_parametersTable_4_0= ruleParametersTable ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStepParametersAccess().getParametersKeyword_0());
            		
            // InternalCucumber.g:287:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:288:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:288:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:289:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getStepParametersAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepParametersRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_9); 

            			newLeafNode(this_EOL_2, grammarAccess.getStepParametersAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:310:3: ( (lv_statements_3_0= ruleStatement ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_WORD) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCucumber.g:311:4: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalCucumber.g:311:4: (lv_statements_3_0= ruleStatement )
            	    // InternalCucumber.g:312:5: lv_statements_3_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getStepParametersAccess().getStatementsStatementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStepParametersRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_3_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalCucumber.g:329:3: ( (lv_parametersTable_4_0= ruleParametersTable ) )
            // InternalCucumber.g:330:4: (lv_parametersTable_4_0= ruleParametersTable )
            {
            // InternalCucumber.g:330:4: (lv_parametersTable_4_0= ruleParametersTable )
            // InternalCucumber.g:331:5: lv_parametersTable_4_0= ruleParametersTable
            {

            					newCompositeNode(grammarAccess.getStepParametersAccess().getParametersTableParametersTableParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_parametersTable_4_0=ruleParametersTable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepParametersRule());
            					}
            					set(
            						current,
            						"parametersTable",
            						lv_parametersTable_4_0,
            						"org.farhan.dsl.cucumber.Cucumber.ParametersTable");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStepParameters"


    // $ANTLR start "entryRuleParametersTable"
    // InternalCucumber.g:352:1: entryRuleParametersTable returns [EObject current=null] : iv_ruleParametersTable= ruleParametersTable EOF ;
    public final EObject entryRuleParametersTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParametersTable = null;


        try {
            // InternalCucumber.g:352:56: (iv_ruleParametersTable= ruleParametersTable EOF )
            // InternalCucumber.g:353:2: iv_ruleParametersTable= ruleParametersTable EOF
            {
             newCompositeNode(grammarAccess.getParametersTableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParametersTable=ruleParametersTable();

            state._fsp--;

             current =iv_ruleParametersTable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParametersTable"


    // $ANTLR start "ruleParametersTable"
    // InternalCucumber.g:359:1: ruleParametersTable returns [EObject current=null] : ( (lv_rows_0_0= ruleRow ) )+ ;
    public final EObject ruleParametersTable() throws RecognitionException {
        EObject current = null;

        EObject lv_rows_0_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:365:2: ( ( (lv_rows_0_0= ruleRow ) )+ )
            // InternalCucumber.g:366:2: ( (lv_rows_0_0= ruleRow ) )+
            {
            // InternalCucumber.g:366:2: ( (lv_rows_0_0= ruleRow ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==17) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalCucumber.g:367:3: (lv_rows_0_0= ruleRow )
            	    {
            	    // InternalCucumber.g:367:3: (lv_rows_0_0= ruleRow )
            	    // InternalCucumber.g:368:4: lv_rows_0_0= ruleRow
            	    {

            	    				newCompositeNode(grammarAccess.getParametersTableAccess().getRowsRowParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_10);
            	    lv_rows_0_0=ruleRow();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getParametersTableRule());
            	    				}
            	    				add(
            	    					current,
            	    					"rows",
            	    					lv_rows_0_0,
            	    					"org.farhan.dsl.cucumber.Cucumber.Row");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParametersTable"


    // $ANTLR start "entryRuleFeature"
    // InternalCucumber.g:388:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // InternalCucumber.g:388:48: (iv_ruleFeature= ruleFeature EOF )
            // InternalCucumber.g:389:2: iv_ruleFeature= ruleFeature EOF
            {
             newCompositeNode(grammarAccess.getFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeature=ruleFeature();

            state._fsp--;

             current =iv_ruleFeature; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalCucumber.g:395:1: ruleFeature returns [EObject current=null] : ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Feature:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_abstractScenarios_6_0= ruleAbstractScenario ) )* ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        Token this_EOL_1=null;
        Token otherlv_2=null;
        Token this_EOL_4=null;
        EObject lv_tags_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_statements_5_0 = null;

        EObject lv_abstractScenarios_6_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:401:2: ( ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Feature:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_abstractScenarios_6_0= ruleAbstractScenario ) )* ) )
            // InternalCucumber.g:402:2: ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Feature:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_abstractScenarios_6_0= ruleAbstractScenario ) )* )
            {
            // InternalCucumber.g:402:2: ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Feature:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_abstractScenarios_6_0= ruleAbstractScenario ) )* )
            // InternalCucumber.g:403:3: ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Feature:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_abstractScenarios_6_0= ruleAbstractScenario ) )*
            {
            // InternalCucumber.g:403:3: ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalCucumber.g:404:4: ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL
                    {
                    // InternalCucumber.g:404:4: ( (lv_tags_0_0= ruleTag ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==24) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalCucumber.g:405:5: (lv_tags_0_0= ruleTag )
                    	    {
                    	    // InternalCucumber.g:405:5: (lv_tags_0_0= ruleTag )
                    	    // InternalCucumber.g:406:6: lv_tags_0_0= ruleTag
                    	    {

                    	    						newCompositeNode(grammarAccess.getFeatureAccess().getTagsTagParserRuleCall_0_0_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
                    	    lv_tags_0_0=ruleTag();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getFeatureRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"tags",
                    	    							lv_tags_0_0,
                    	    							"org.farhan.dsl.cucumber.Cucumber.Tag");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_12); 

                    				newLeafNode(this_EOL_1, grammarAccess.getFeatureAccess().getEOLTerminalRuleCall_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getFeatureAccess().getFeatureKeyword_1());
            		
            // InternalCucumber.g:432:3: ( (lv_name_3_0= ruleTitle ) )
            // InternalCucumber.g:433:4: (lv_name_3_0= ruleTitle )
            {
            // InternalCucumber.g:433:4: (lv_name_3_0= ruleTitle )
            // InternalCucumber.g:434:5: lv_name_3_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getFeatureAccess().getNameTitleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_3_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFeatureRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_13); 

            			newLeafNode(this_EOL_4, grammarAccess.getFeatureAccess().getEOLTerminalRuleCall_3());
            		
            // InternalCucumber.g:455:3: ( (lv_statements_5_0= ruleStatement ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_WORD) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalCucumber.g:456:4: (lv_statements_5_0= ruleStatement )
            	    {
            	    // InternalCucumber.g:456:4: (lv_statements_5_0= ruleStatement )
            	    // InternalCucumber.g:457:5: lv_statements_5_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getFeatureAccess().getStatementsStatementParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_statements_5_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFeatureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_5_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalCucumber.g:474:3: ( (lv_abstractScenarios_6_0= ruleAbstractScenario ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=13 && LA11_0<=15)||LA11_0==24) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalCucumber.g:475:4: (lv_abstractScenarios_6_0= ruleAbstractScenario )
            	    {
            	    // InternalCucumber.g:475:4: (lv_abstractScenarios_6_0= ruleAbstractScenario )
            	    // InternalCucumber.g:476:5: lv_abstractScenarios_6_0= ruleAbstractScenario
            	    {

            	    					newCompositeNode(grammarAccess.getFeatureAccess().getAbstractScenariosAbstractScenarioParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_abstractScenarios_6_0=ruleAbstractScenario();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFeatureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"abstractScenarios",
            	    						lv_abstractScenarios_6_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.AbstractScenario");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleAbstractScenario"
    // InternalCucumber.g:497:1: entryRuleAbstractScenario returns [EObject current=null] : iv_ruleAbstractScenario= ruleAbstractScenario EOF ;
    public final EObject entryRuleAbstractScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractScenario = null;


        try {
            // InternalCucumber.g:497:57: (iv_ruleAbstractScenario= ruleAbstractScenario EOF )
            // InternalCucumber.g:498:2: iv_ruleAbstractScenario= ruleAbstractScenario EOF
            {
             newCompositeNode(grammarAccess.getAbstractScenarioRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractScenario=ruleAbstractScenario();

            state._fsp--;

             current =iv_ruleAbstractScenario; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractScenario"


    // $ANTLR start "ruleAbstractScenario"
    // InternalCucumber.g:504:1: ruleAbstractScenario returns [EObject current=null] : (this_Background_0= ruleBackground | this_Scenario_1= ruleScenario | this_ScenarioOutline_2= ruleScenarioOutline ) ;
    public final EObject ruleAbstractScenario() throws RecognitionException {
        EObject current = null;

        EObject this_Background_0 = null;

        EObject this_Scenario_1 = null;

        EObject this_ScenarioOutline_2 = null;



        	enterRule();

        try {
            // InternalCucumber.g:510:2: ( (this_Background_0= ruleBackground | this_Scenario_1= ruleScenario | this_ScenarioOutline_2= ruleScenarioOutline ) )
            // InternalCucumber.g:511:2: (this_Background_0= ruleBackground | this_Scenario_1= ruleScenario | this_ScenarioOutline_2= ruleScenarioOutline )
            {
            // InternalCucumber.g:511:2: (this_Background_0= ruleBackground | this_Scenario_1= ruleScenario | this_ScenarioOutline_2= ruleScenarioOutline )
            int alt12=3;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalCucumber.g:512:3: this_Background_0= ruleBackground
                    {

                    			newCompositeNode(grammarAccess.getAbstractScenarioAccess().getBackgroundParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Background_0=ruleBackground();

                    state._fsp--;


                    			current = this_Background_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalCucumber.g:521:3: this_Scenario_1= ruleScenario
                    {

                    			newCompositeNode(grammarAccess.getAbstractScenarioAccess().getScenarioParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Scenario_1=ruleScenario();

                    state._fsp--;


                    			current = this_Scenario_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalCucumber.g:530:3: this_ScenarioOutline_2= ruleScenarioOutline
                    {

                    			newCompositeNode(grammarAccess.getAbstractScenarioAccess().getScenarioOutlineParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScenarioOutline_2=ruleScenarioOutline();

                    state._fsp--;


                    			current = this_ScenarioOutline_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractScenario"


    // $ANTLR start "entryRuleBackground"
    // InternalCucumber.g:542:1: entryRuleBackground returns [EObject current=null] : iv_ruleBackground= ruleBackground EOF ;
    public final EObject entryRuleBackground() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBackground = null;


        try {
            // InternalCucumber.g:542:51: (iv_ruleBackground= ruleBackground EOF )
            // InternalCucumber.g:543:2: iv_ruleBackground= ruleBackground EOF
            {
             newCompositeNode(grammarAccess.getBackgroundRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBackground=ruleBackground();

            state._fsp--;

             current =iv_ruleBackground; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBackground"


    // $ANTLR start "ruleBackground"
    // InternalCucumber.g:549:1: ruleBackground returns [EObject current=null] : (otherlv_0= 'Background:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_steps_4_0= ruleStep ) )* ) ;
    public final EObject ruleBackground() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_statements_3_0 = null;

        EObject lv_steps_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:555:2: ( (otherlv_0= 'Background:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_steps_4_0= ruleStep ) )* ) )
            // InternalCucumber.g:556:2: (otherlv_0= 'Background:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_steps_4_0= ruleStep ) )* )
            {
            // InternalCucumber.g:556:2: (otherlv_0= 'Background:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_steps_4_0= ruleStep ) )* )
            // InternalCucumber.g:557:3: otherlv_0= 'Background:' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( (lv_statements_3_0= ruleStatement ) )* ( (lv_steps_4_0= ruleStep ) )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBackgroundAccess().getBackgroundKeyword_0());
            		
            // InternalCucumber.g:561:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:562:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:562:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:563:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getBackgroundAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBackgroundRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_15); 

            			newLeafNode(this_EOL_2, grammarAccess.getBackgroundAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:584:3: ( (lv_statements_3_0= ruleStatement ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_WORD) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalCucumber.g:585:4: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalCucumber.g:585:4: (lv_statements_3_0= ruleStatement )
            	    // InternalCucumber.g:586:5: lv_statements_3_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getBackgroundAccess().getStatementsStatementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBackgroundRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_3_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalCucumber.g:603:3: ( (lv_steps_4_0= ruleStep ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=18 && LA14_0<=23)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalCucumber.g:604:4: (lv_steps_4_0= ruleStep )
            	    {
            	    // InternalCucumber.g:604:4: (lv_steps_4_0= ruleStep )
            	    // InternalCucumber.g:605:5: lv_steps_4_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getBackgroundAccess().getStepsStepParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_steps_4_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBackgroundRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_4_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBackground"


    // $ANTLR start "entryRuleScenario"
    // InternalCucumber.g:626:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // InternalCucumber.g:626:49: (iv_ruleScenario= ruleScenario EOF )
            // InternalCucumber.g:627:2: iv_ruleScenario= ruleScenario EOF
            {
             newCompositeNode(grammarAccess.getScenarioRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenario=ruleScenario();

            state._fsp--;

             current =iv_ruleScenario; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario"


    // $ANTLR start "ruleScenario"
    // InternalCucumber.g:633:1: ruleScenario returns [EObject current=null] : ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )* ) ;
    public final EObject ruleScenario() throws RecognitionException {
        EObject current = null;

        Token this_EOL_1=null;
        Token otherlv_2=null;
        Token this_EOL_4=null;
        EObject lv_tags_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_statements_5_0 = null;

        EObject lv_steps_6_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:639:2: ( ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )* ) )
            // InternalCucumber.g:640:2: ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )* )
            {
            // InternalCucumber.g:640:2: ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )* )
            // InternalCucumber.g:641:3: ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )*
            {
            // InternalCucumber.g:641:3: ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalCucumber.g:642:4: ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL
                    {
                    // InternalCucumber.g:642:4: ( (lv_tags_0_0= ruleTag ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==24) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalCucumber.g:643:5: (lv_tags_0_0= ruleTag )
                    	    {
                    	    // InternalCucumber.g:643:5: (lv_tags_0_0= ruleTag )
                    	    // InternalCucumber.g:644:6: lv_tags_0_0= ruleTag
                    	    {

                    	    						newCompositeNode(grammarAccess.getScenarioAccess().getTagsTagParserRuleCall_0_0_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
                    	    lv_tags_0_0=ruleTag();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getScenarioRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"tags",
                    	    							lv_tags_0_0,
                    	    							"org.farhan.dsl.cucumber.Cucumber.Tag");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_17); 

                    				newLeafNode(this_EOL_1, grammarAccess.getScenarioAccess().getEOLTerminalRuleCall_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getScenarioAccess().getScenarioKeyword_1());
            		
            // InternalCucumber.g:670:3: ( (lv_name_3_0= ruleTitle ) )
            // InternalCucumber.g:671:4: (lv_name_3_0= ruleTitle )
            {
            // InternalCucumber.g:671:4: (lv_name_3_0= ruleTitle )
            // InternalCucumber.g:672:5: lv_name_3_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getScenarioAccess().getNameTitleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_3_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_15); 

            			newLeafNode(this_EOL_4, grammarAccess.getScenarioAccess().getEOLTerminalRuleCall_3());
            		
            // InternalCucumber.g:693:3: ( (lv_statements_5_0= ruleStatement ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_WORD) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalCucumber.g:694:4: (lv_statements_5_0= ruleStatement )
            	    {
            	    // InternalCucumber.g:694:4: (lv_statements_5_0= ruleStatement )
            	    // InternalCucumber.g:695:5: lv_statements_5_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getScenarioAccess().getStatementsStatementParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_statements_5_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScenarioRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_5_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // InternalCucumber.g:712:3: ( (lv_steps_6_0= ruleStep ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=18 && LA18_0<=23)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalCucumber.g:713:4: (lv_steps_6_0= ruleStep )
            	    {
            	    // InternalCucumber.g:713:4: (lv_steps_6_0= ruleStep )
            	    // InternalCucumber.g:714:5: lv_steps_6_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getScenarioAccess().getStepsStepParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_steps_6_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScenarioRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_6_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleScenarioOutline"
    // InternalCucumber.g:735:1: entryRuleScenarioOutline returns [EObject current=null] : iv_ruleScenarioOutline= ruleScenarioOutline EOF ;
    public final EObject entryRuleScenarioOutline() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenarioOutline = null;


        try {
            // InternalCucumber.g:735:56: (iv_ruleScenarioOutline= ruleScenarioOutline EOF )
            // InternalCucumber.g:736:2: iv_ruleScenarioOutline= ruleScenarioOutline EOF
            {
             newCompositeNode(grammarAccess.getScenarioOutlineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenarioOutline=ruleScenarioOutline();

            state._fsp--;

             current =iv_ruleScenarioOutline; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenarioOutline"


    // $ANTLR start "ruleScenarioOutline"
    // InternalCucumber.g:742:1: ruleScenarioOutline returns [EObject current=null] : ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario Outline:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )* ( (lv_examples_7_0= ruleExamples ) )+ ) ;
    public final EObject ruleScenarioOutline() throws RecognitionException {
        EObject current = null;

        Token this_EOL_1=null;
        Token otherlv_2=null;
        Token this_EOL_4=null;
        EObject lv_tags_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_statements_5_0 = null;

        EObject lv_steps_6_0 = null;

        EObject lv_examples_7_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:748:2: ( ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario Outline:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )* ( (lv_examples_7_0= ruleExamples ) )+ ) )
            // InternalCucumber.g:749:2: ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario Outline:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )* ( (lv_examples_7_0= ruleExamples ) )+ )
            {
            // InternalCucumber.g:749:2: ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario Outline:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )* ( (lv_examples_7_0= ruleExamples ) )+ )
            // InternalCucumber.g:750:3: ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Scenario Outline:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_steps_6_0= ruleStep ) )* ( (lv_examples_7_0= ruleExamples ) )+
            {
            // InternalCucumber.g:750:3: ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==24) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalCucumber.g:751:4: ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL
                    {
                    // InternalCucumber.g:751:4: ( (lv_tags_0_0= ruleTag ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==24) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalCucumber.g:752:5: (lv_tags_0_0= ruleTag )
                    	    {
                    	    // InternalCucumber.g:752:5: (lv_tags_0_0= ruleTag )
                    	    // InternalCucumber.g:753:6: lv_tags_0_0= ruleTag
                    	    {

                    	    						newCompositeNode(grammarAccess.getScenarioOutlineAccess().getTagsTagParserRuleCall_0_0_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
                    	    lv_tags_0_0=ruleTag();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getScenarioOutlineRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"tags",
                    	    							lv_tags_0_0,
                    	    							"org.farhan.dsl.cucumber.Cucumber.Tag");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_18); 

                    				newLeafNode(this_EOL_1, grammarAccess.getScenarioOutlineAccess().getEOLTerminalRuleCall_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getScenarioOutlineAccess().getScenarioOutlineKeyword_1());
            		
            // InternalCucumber.g:779:3: ( (lv_name_3_0= ruleTitle ) )
            // InternalCucumber.g:780:4: (lv_name_3_0= ruleTitle )
            {
            // InternalCucumber.g:780:4: (lv_name_3_0= ruleTitle )
            // InternalCucumber.g:781:5: lv_name_3_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getScenarioOutlineAccess().getNameTitleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_3_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioOutlineRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_19); 

            			newLeafNode(this_EOL_4, grammarAccess.getScenarioOutlineAccess().getEOLTerminalRuleCall_3());
            		
            // InternalCucumber.g:802:3: ( (lv_statements_5_0= ruleStatement ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_WORD) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalCucumber.g:803:4: (lv_statements_5_0= ruleStatement )
            	    {
            	    // InternalCucumber.g:803:4: (lv_statements_5_0= ruleStatement )
            	    // InternalCucumber.g:804:5: lv_statements_5_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getScenarioOutlineAccess().getStatementsStatementParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_statements_5_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScenarioOutlineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_5_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalCucumber.g:821:3: ( (lv_steps_6_0= ruleStep ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=18 && LA22_0<=23)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalCucumber.g:822:4: (lv_steps_6_0= ruleStep )
            	    {
            	    // InternalCucumber.g:822:4: (lv_steps_6_0= ruleStep )
            	    // InternalCucumber.g:823:5: lv_steps_6_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getScenarioOutlineAccess().getStepsStepParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_steps_6_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScenarioOutlineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_6_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // InternalCucumber.g:840:3: ( (lv_examples_7_0= ruleExamples ) )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // InternalCucumber.g:841:4: (lv_examples_7_0= ruleExamples )
            	    {
            	    // InternalCucumber.g:841:4: (lv_examples_7_0= ruleExamples )
            	    // InternalCucumber.g:842:5: lv_examples_7_0= ruleExamples
            	    {

            	    					newCompositeNode(grammarAccess.getScenarioOutlineAccess().getExamplesExamplesParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_20);
            	    lv_examples_7_0=ruleExamples();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScenarioOutlineRule());
            	    					}
            	    					add(
            	    						current,
            	    						"examples",
            	    						lv_examples_7_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Examples");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenarioOutline"


    // $ANTLR start "entryRuleExamples"
    // InternalCucumber.g:863:1: entryRuleExamples returns [EObject current=null] : iv_ruleExamples= ruleExamples EOF ;
    public final EObject entryRuleExamples() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExamples = null;


        try {
            // InternalCucumber.g:863:49: (iv_ruleExamples= ruleExamples EOF )
            // InternalCucumber.g:864:2: iv_ruleExamples= ruleExamples EOF
            {
             newCompositeNode(grammarAccess.getExamplesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExamples=ruleExamples();

            state._fsp--;

             current =iv_ruleExamples; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExamples"


    // $ANTLR start "ruleExamples"
    // InternalCucumber.g:870:1: ruleExamples returns [EObject current=null] : ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Examples:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_theExamplesTable_6_0= ruleExamplesTable ) ) ) ;
    public final EObject ruleExamples() throws RecognitionException {
        EObject current = null;

        Token this_EOL_1=null;
        Token otherlv_2=null;
        Token this_EOL_4=null;
        EObject lv_tags_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_statements_5_0 = null;

        EObject lv_theExamplesTable_6_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:876:2: ( ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Examples:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_theExamplesTable_6_0= ruleExamplesTable ) ) ) )
            // InternalCucumber.g:877:2: ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Examples:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_theExamplesTable_6_0= ruleExamplesTable ) ) )
            {
            // InternalCucumber.g:877:2: ( ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Examples:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_theExamplesTable_6_0= ruleExamplesTable ) ) )
            // InternalCucumber.g:878:3: ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )? otherlv_2= 'Examples:' ( (lv_name_3_0= ruleTitle ) ) this_EOL_4= RULE_EOL ( (lv_statements_5_0= ruleStatement ) )* ( (lv_theExamplesTable_6_0= ruleExamplesTable ) )
            {
            // InternalCucumber.g:878:3: ( ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==24) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalCucumber.g:879:4: ( (lv_tags_0_0= ruleTag ) )+ this_EOL_1= RULE_EOL
                    {
                    // InternalCucumber.g:879:4: ( (lv_tags_0_0= ruleTag ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==24) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalCucumber.g:880:5: (lv_tags_0_0= ruleTag )
                    	    {
                    	    // InternalCucumber.g:880:5: (lv_tags_0_0= ruleTag )
                    	    // InternalCucumber.g:881:6: lv_tags_0_0= ruleTag
                    	    {

                    	    						newCompositeNode(grammarAccess.getExamplesAccess().getTagsTagParserRuleCall_0_0_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
                    	    lv_tags_0_0=ruleTag();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getExamplesRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"tags",
                    	    							lv_tags_0_0,
                    	    							"org.farhan.dsl.cucumber.Cucumber.Tag");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_21); 

                    				newLeafNode(this_EOL_1, grammarAccess.getExamplesAccess().getEOLTerminalRuleCall_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getExamplesAccess().getExamplesKeyword_1());
            		
            // InternalCucumber.g:907:3: ( (lv_name_3_0= ruleTitle ) )
            // InternalCucumber.g:908:4: (lv_name_3_0= ruleTitle )
            {
            // InternalCucumber.g:908:4: (lv_name_3_0= ruleTitle )
            // InternalCucumber.g:909:5: lv_name_3_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getExamplesAccess().getNameTitleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_3_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExamplesRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_9); 

            			newLeafNode(this_EOL_4, grammarAccess.getExamplesAccess().getEOLTerminalRuleCall_3());
            		
            // InternalCucumber.g:930:3: ( (lv_statements_5_0= ruleStatement ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_WORD) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalCucumber.g:931:4: (lv_statements_5_0= ruleStatement )
            	    {
            	    // InternalCucumber.g:931:4: (lv_statements_5_0= ruleStatement )
            	    // InternalCucumber.g:932:5: lv_statements_5_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getExamplesAccess().getStatementsStatementParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_statements_5_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getExamplesRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_5_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // InternalCucumber.g:949:3: ( (lv_theExamplesTable_6_0= ruleExamplesTable ) )
            // InternalCucumber.g:950:4: (lv_theExamplesTable_6_0= ruleExamplesTable )
            {
            // InternalCucumber.g:950:4: (lv_theExamplesTable_6_0= ruleExamplesTable )
            // InternalCucumber.g:951:5: lv_theExamplesTable_6_0= ruleExamplesTable
            {

            					newCompositeNode(grammarAccess.getExamplesAccess().getTheExamplesTableExamplesTableParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_theExamplesTable_6_0=ruleExamplesTable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExamplesRule());
            					}
            					set(
            						current,
            						"theExamplesTable",
            						lv_theExamplesTable_6_0,
            						"org.farhan.dsl.cucumber.Cucumber.ExamplesTable");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExamples"


    // $ANTLR start "entryRuleExamplesTable"
    // InternalCucumber.g:972:1: entryRuleExamplesTable returns [EObject current=null] : iv_ruleExamplesTable= ruleExamplesTable EOF ;
    public final EObject entryRuleExamplesTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExamplesTable = null;


        try {
            // InternalCucumber.g:972:54: (iv_ruleExamplesTable= ruleExamplesTable EOF )
            // InternalCucumber.g:973:2: iv_ruleExamplesTable= ruleExamplesTable EOF
            {
             newCompositeNode(grammarAccess.getExamplesTableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExamplesTable=ruleExamplesTable();

            state._fsp--;

             current =iv_ruleExamplesTable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExamplesTable"


    // $ANTLR start "ruleExamplesTable"
    // InternalCucumber.g:979:1: ruleExamplesTable returns [EObject current=null] : ( (lv_rows_0_0= ruleRow ) )+ ;
    public final EObject ruleExamplesTable() throws RecognitionException {
        EObject current = null;

        EObject lv_rows_0_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:985:2: ( ( (lv_rows_0_0= ruleRow ) )+ )
            // InternalCucumber.g:986:2: ( (lv_rows_0_0= ruleRow ) )+
            {
            // InternalCucumber.g:986:2: ( (lv_rows_0_0= ruleRow ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==17) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalCucumber.g:987:3: (lv_rows_0_0= ruleRow )
            	    {
            	    // InternalCucumber.g:987:3: (lv_rows_0_0= ruleRow )
            	    // InternalCucumber.g:988:4: lv_rows_0_0= ruleRow
            	    {

            	    				newCompositeNode(grammarAccess.getExamplesTableAccess().getRowsRowParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_10);
            	    lv_rows_0_0=ruleRow();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getExamplesTableRule());
            	    				}
            	    				add(
            	    					current,
            	    					"rows",
            	    					lv_rows_0_0,
            	    					"org.farhan.dsl.cucumber.Cucumber.Row");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExamplesTable"


    // $ANTLR start "entryRuleStepTable"
    // InternalCucumber.g:1008:1: entryRuleStepTable returns [EObject current=null] : iv_ruleStepTable= ruleStepTable EOF ;
    public final EObject entryRuleStepTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepTable = null;


        try {
            // InternalCucumber.g:1008:50: (iv_ruleStepTable= ruleStepTable EOF )
            // InternalCucumber.g:1009:2: iv_ruleStepTable= ruleStepTable EOF
            {
             newCompositeNode(grammarAccess.getStepTableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStepTable=ruleStepTable();

            state._fsp--;

             current =iv_ruleStepTable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStepTable"


    // $ANTLR start "ruleStepTable"
    // InternalCucumber.g:1015:1: ruleStepTable returns [EObject current=null] : ( (lv_rows_0_0= ruleRow ) )+ ;
    public final EObject ruleStepTable() throws RecognitionException {
        EObject current = null;

        EObject lv_rows_0_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1021:2: ( ( (lv_rows_0_0= ruleRow ) )+ )
            // InternalCucumber.g:1022:2: ( (lv_rows_0_0= ruleRow ) )+
            {
            // InternalCucumber.g:1022:2: ( (lv_rows_0_0= ruleRow ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==17) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalCucumber.g:1023:3: (lv_rows_0_0= ruleRow )
            	    {
            	    // InternalCucumber.g:1023:3: (lv_rows_0_0= ruleRow )
            	    // InternalCucumber.g:1024:4: lv_rows_0_0= ruleRow
            	    {

            	    				newCompositeNode(grammarAccess.getStepTableAccess().getRowsRowParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_10);
            	    lv_rows_0_0=ruleRow();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getStepTableRule());
            	    				}
            	    				add(
            	    					current,
            	    					"rows",
            	    					lv_rows_0_0,
            	    					"org.farhan.dsl.cucumber.Cucumber.Row");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStepTable"


    // $ANTLR start "entryRuleRow"
    // InternalCucumber.g:1044:1: entryRuleRow returns [EObject current=null] : iv_ruleRow= ruleRow EOF ;
    public final EObject entryRuleRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRow = null;


        try {
            // InternalCucumber.g:1044:44: (iv_ruleRow= ruleRow EOF )
            // InternalCucumber.g:1045:2: iv_ruleRow= ruleRow EOF
            {
             newCompositeNode(grammarAccess.getRowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRow=ruleRow();

            state._fsp--;

             current =iv_ruleRow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRow"


    // $ANTLR start "ruleRow"
    // InternalCucumber.g:1051:1: ruleRow returns [EObject current=null] : ( ( (lv_cells_0_0= ruleCell ) )+ otherlv_1= '|' this_EOL_2= RULE_EOL ) ;
    public final EObject ruleRow() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_EOL_2=null;
        EObject lv_cells_0_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1057:2: ( ( ( (lv_cells_0_0= ruleCell ) )+ otherlv_1= '|' this_EOL_2= RULE_EOL ) )
            // InternalCucumber.g:1058:2: ( ( (lv_cells_0_0= ruleCell ) )+ otherlv_1= '|' this_EOL_2= RULE_EOL )
            {
            // InternalCucumber.g:1058:2: ( ( (lv_cells_0_0= ruleCell ) )+ otherlv_1= '|' this_EOL_2= RULE_EOL )
            // InternalCucumber.g:1059:3: ( (lv_cells_0_0= ruleCell ) )+ otherlv_1= '|' this_EOL_2= RULE_EOL
            {
            // InternalCucumber.g:1059:3: ( (lv_cells_0_0= ruleCell ) )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==17) ) {
                    int LA29_1 = input.LA(2);

                    if ( (LA29_1==RULE_WORD) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // InternalCucumber.g:1060:4: (lv_cells_0_0= ruleCell )
            	    {
            	    // InternalCucumber.g:1060:4: (lv_cells_0_0= ruleCell )
            	    // InternalCucumber.g:1061:5: lv_cells_0_0= ruleCell
            	    {

            	    					newCompositeNode(grammarAccess.getRowAccess().getCellsCellParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_cells_0_0=ruleCell();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRowRule());
            	    					}
            	    					add(
            	    						current,
            	    						"cells",
            	    						lv_cells_0_0,
            	    						"org.farhan.dsl.cucumber.Cucumber.Cell");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            otherlv_1=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getRowAccess().getVerticalLineKeyword_1());
            		
            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_2); 

            			newLeafNode(this_EOL_2, grammarAccess.getRowAccess().getEOLTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRow"


    // $ANTLR start "entryRuleCell"
    // InternalCucumber.g:1090:1: entryRuleCell returns [EObject current=null] : iv_ruleCell= ruleCell EOF ;
    public final EObject entryRuleCell() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCell = null;


        try {
            // InternalCucumber.g:1090:45: (iv_ruleCell= ruleCell EOF )
            // InternalCucumber.g:1091:2: iv_ruleCell= ruleCell EOF
            {
             newCompositeNode(grammarAccess.getCellRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCell=ruleCell();

            state._fsp--;

             current =iv_ruleCell; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCell"


    // $ANTLR start "ruleCell"
    // InternalCucumber.g:1097:1: ruleCell returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleTitle ) ) ) ;
    public final EObject ruleCell() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1103:2: ( (otherlv_0= '|' ( (lv_name_1_0= ruleTitle ) ) ) )
            // InternalCucumber.g:1104:2: (otherlv_0= '|' ( (lv_name_1_0= ruleTitle ) ) )
            {
            // InternalCucumber.g:1104:2: (otherlv_0= '|' ( (lv_name_1_0= ruleTitle ) ) )
            // InternalCucumber.g:1105:3: otherlv_0= '|' ( (lv_name_1_0= ruleTitle ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCellAccess().getVerticalLineKeyword_0());
            		
            // InternalCucumber.g:1109:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:1110:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:1110:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:1111:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getCellAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCellRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCell"


    // $ANTLR start "entryRuleStep"
    // InternalCucumber.g:1132:1: entryRuleStep returns [EObject current=null] : iv_ruleStep= ruleStep EOF ;
    public final EObject entryRuleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStep = null;


        try {
            // InternalCucumber.g:1132:45: (iv_ruleStep= ruleStep EOF )
            // InternalCucumber.g:1133:2: iv_ruleStep= ruleStep EOF
            {
             newCompositeNode(grammarAccess.getStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStep=ruleStep();

            state._fsp--;

             current =iv_ruleStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStep"


    // $ANTLR start "ruleStep"
    // InternalCucumber.g:1139:1: ruleStep returns [EObject current=null] : (this_Given_0= ruleGiven | this_When_1= ruleWhen | this_Then_2= ruleThen | this_And_3= ruleAnd | this_But_4= ruleBut | this_Asterisk_5= ruleAsterisk ) ;
    public final EObject ruleStep() throws RecognitionException {
        EObject current = null;

        EObject this_Given_0 = null;

        EObject this_When_1 = null;

        EObject this_Then_2 = null;

        EObject this_And_3 = null;

        EObject this_But_4 = null;

        EObject this_Asterisk_5 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1145:2: ( (this_Given_0= ruleGiven | this_When_1= ruleWhen | this_Then_2= ruleThen | this_And_3= ruleAnd | this_But_4= ruleBut | this_Asterisk_5= ruleAsterisk ) )
            // InternalCucumber.g:1146:2: (this_Given_0= ruleGiven | this_When_1= ruleWhen | this_Then_2= ruleThen | this_And_3= ruleAnd | this_But_4= ruleBut | this_Asterisk_5= ruleAsterisk )
            {
            // InternalCucumber.g:1146:2: (this_Given_0= ruleGiven | this_When_1= ruleWhen | this_Then_2= ruleThen | this_And_3= ruleAnd | this_But_4= ruleBut | this_Asterisk_5= ruleAsterisk )
            int alt30=6;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt30=1;
                }
                break;
            case 19:
                {
                alt30=2;
                }
                break;
            case 20:
                {
                alt30=3;
                }
                break;
            case 21:
                {
                alt30=4;
                }
                break;
            case 22:
                {
                alt30=5;
                }
                break;
            case 23:
                {
                alt30=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalCucumber.g:1147:3: this_Given_0= ruleGiven
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getGivenParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Given_0=ruleGiven();

                    state._fsp--;


                    			current = this_Given_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1156:3: this_When_1= ruleWhen
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getWhenParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_When_1=ruleWhen();

                    state._fsp--;


                    			current = this_When_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalCucumber.g:1165:3: this_Then_2= ruleThen
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getThenParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Then_2=ruleThen();

                    state._fsp--;


                    			current = this_Then_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalCucumber.g:1174:3: this_And_3= ruleAnd
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getAndParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_And_3=ruleAnd();

                    state._fsp--;


                    			current = this_And_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalCucumber.g:1183:3: this_But_4= ruleBut
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getButParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_But_4=ruleBut();

                    state._fsp--;


                    			current = this_But_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalCucumber.g:1192:3: this_Asterisk_5= ruleAsterisk
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getAsteriskParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Asterisk_5=ruleAsterisk();

                    state._fsp--;


                    			current = this_Asterisk_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStep"


    // $ANTLR start "entryRuleDocString"
    // InternalCucumber.g:1204:1: entryRuleDocString returns [EObject current=null] : iv_ruleDocString= ruleDocString EOF ;
    public final EObject entryRuleDocString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocString = null;


        try {
            // InternalCucumber.g:1204:50: (iv_ruleDocString= ruleDocString EOF )
            // InternalCucumber.g:1205:2: iv_ruleDocString= ruleDocString EOF
            {
             newCompositeNode(grammarAccess.getDocStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDocString=ruleDocString();

            state._fsp--;

             current =iv_ruleDocString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocString"


    // $ANTLR start "ruleDocString"
    // InternalCucumber.g:1211:1: ruleDocString returns [EObject current=null] : ( ( (lv_name_0_0= RULE_RAWTEXT ) ) this_EOL_1= RULE_EOL ) ;
    public final EObject ruleDocString() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_EOL_1=null;


        	enterRule();

        try {
            // InternalCucumber.g:1217:2: ( ( ( (lv_name_0_0= RULE_RAWTEXT ) ) this_EOL_1= RULE_EOL ) )
            // InternalCucumber.g:1218:2: ( ( (lv_name_0_0= RULE_RAWTEXT ) ) this_EOL_1= RULE_EOL )
            {
            // InternalCucumber.g:1218:2: ( ( (lv_name_0_0= RULE_RAWTEXT ) ) this_EOL_1= RULE_EOL )
            // InternalCucumber.g:1219:3: ( (lv_name_0_0= RULE_RAWTEXT ) ) this_EOL_1= RULE_EOL
            {
            // InternalCucumber.g:1219:3: ( (lv_name_0_0= RULE_RAWTEXT ) )
            // InternalCucumber.g:1220:4: (lv_name_0_0= RULE_RAWTEXT )
            {
            // InternalCucumber.g:1220:4: (lv_name_0_0= RULE_RAWTEXT )
            // InternalCucumber.g:1221:5: lv_name_0_0= RULE_RAWTEXT
            {
            lv_name_0_0=(Token)match(input,RULE_RAWTEXT,FOLLOW_4); 

            					newLeafNode(lv_name_0_0, grammarAccess.getDocStringAccess().getNameRAWTEXTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDocStringRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.farhan.dsl.cucumber.Cucumber.RAWTEXT");
            				

            }


            }

            this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_2); 

            			newLeafNode(this_EOL_1, grammarAccess.getDocStringAccess().getEOLTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocString"


    // $ANTLR start "entryRuleGiven"
    // InternalCucumber.g:1245:1: entryRuleGiven returns [EObject current=null] : iv_ruleGiven= ruleGiven EOF ;
    public final EObject entryRuleGiven() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGiven = null;


        try {
            // InternalCucumber.g:1245:46: (iv_ruleGiven= ruleGiven EOF )
            // InternalCucumber.g:1246:2: iv_ruleGiven= ruleGiven EOF
            {
             newCompositeNode(grammarAccess.getGivenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGiven=ruleGiven();

            state._fsp--;

             current =iv_ruleGiven; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGiven"


    // $ANTLR start "ruleGiven"
    // InternalCucumber.g:1252:1: ruleGiven returns [EObject current=null] : (otherlv_0= 'Given' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) ;
    public final EObject ruleGiven() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_theStepTable_3_0 = null;

        EObject lv_theDocString_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1258:2: ( (otherlv_0= 'Given' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) )
            // InternalCucumber.g:1259:2: (otherlv_0= 'Given' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            {
            // InternalCucumber.g:1259:2: (otherlv_0= 'Given' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            // InternalCucumber.g:1260:3: otherlv_0= 'Given' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGivenAccess().getGivenKeyword_0());
            		
            // InternalCucumber.g:1264:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:1265:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:1265:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:1266:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getGivenAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGivenRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_22); 

            			newLeafNode(this_EOL_2, grammarAccess.getGivenAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:1287:3: ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            int alt31=3;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==17) ) {
                alt31=1;
            }
            else if ( (LA31_0==RULE_RAWTEXT) ) {
                alt31=2;
            }
            switch (alt31) {
                case 1 :
                    // InternalCucumber.g:1288:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    {
                    // InternalCucumber.g:1288:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    // InternalCucumber.g:1289:5: (lv_theStepTable_3_0= ruleStepTable )
                    {
                    // InternalCucumber.g:1289:5: (lv_theStepTable_3_0= ruleStepTable )
                    // InternalCucumber.g:1290:6: lv_theStepTable_3_0= ruleStepTable
                    {

                    						newCompositeNode(grammarAccess.getGivenAccess().getTheStepTableStepTableParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theStepTable_3_0=ruleStepTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGivenRule());
                    						}
                    						set(
                    							current,
                    							"theStepTable",
                    							lv_theStepTable_3_0,
                    							"org.farhan.dsl.cucumber.Cucumber.StepTable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1308:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    {
                    // InternalCucumber.g:1308:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    // InternalCucumber.g:1309:5: (lv_theDocString_4_0= ruleDocString )
                    {
                    // InternalCucumber.g:1309:5: (lv_theDocString_4_0= ruleDocString )
                    // InternalCucumber.g:1310:6: lv_theDocString_4_0= ruleDocString
                    {

                    						newCompositeNode(grammarAccess.getGivenAccess().getTheDocStringDocStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theDocString_4_0=ruleDocString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGivenRule());
                    						}
                    						set(
                    							current,
                    							"theDocString",
                    							lv_theDocString_4_0,
                    							"org.farhan.dsl.cucumber.Cucumber.DocString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGiven"


    // $ANTLR start "entryRuleWhen"
    // InternalCucumber.g:1332:1: entryRuleWhen returns [EObject current=null] : iv_ruleWhen= ruleWhen EOF ;
    public final EObject entryRuleWhen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhen = null;


        try {
            // InternalCucumber.g:1332:45: (iv_ruleWhen= ruleWhen EOF )
            // InternalCucumber.g:1333:2: iv_ruleWhen= ruleWhen EOF
            {
             newCompositeNode(grammarAccess.getWhenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWhen=ruleWhen();

            state._fsp--;

             current =iv_ruleWhen; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhen"


    // $ANTLR start "ruleWhen"
    // InternalCucumber.g:1339:1: ruleWhen returns [EObject current=null] : (otherlv_0= 'When' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) ;
    public final EObject ruleWhen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_theStepTable_3_0 = null;

        EObject lv_theDocString_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1345:2: ( (otherlv_0= 'When' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) )
            // InternalCucumber.g:1346:2: (otherlv_0= 'When' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            {
            // InternalCucumber.g:1346:2: (otherlv_0= 'When' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            // InternalCucumber.g:1347:3: otherlv_0= 'When' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getWhenAccess().getWhenKeyword_0());
            		
            // InternalCucumber.g:1351:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:1352:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:1352:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:1353:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getWhenAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhenRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_22); 

            			newLeafNode(this_EOL_2, grammarAccess.getWhenAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:1374:3: ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==17) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_RAWTEXT) ) {
                alt32=2;
            }
            switch (alt32) {
                case 1 :
                    // InternalCucumber.g:1375:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    {
                    // InternalCucumber.g:1375:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    // InternalCucumber.g:1376:5: (lv_theStepTable_3_0= ruleStepTable )
                    {
                    // InternalCucumber.g:1376:5: (lv_theStepTable_3_0= ruleStepTable )
                    // InternalCucumber.g:1377:6: lv_theStepTable_3_0= ruleStepTable
                    {

                    						newCompositeNode(grammarAccess.getWhenAccess().getTheStepTableStepTableParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theStepTable_3_0=ruleStepTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWhenRule());
                    						}
                    						set(
                    							current,
                    							"theStepTable",
                    							lv_theStepTable_3_0,
                    							"org.farhan.dsl.cucumber.Cucumber.StepTable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1395:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    {
                    // InternalCucumber.g:1395:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    // InternalCucumber.g:1396:5: (lv_theDocString_4_0= ruleDocString )
                    {
                    // InternalCucumber.g:1396:5: (lv_theDocString_4_0= ruleDocString )
                    // InternalCucumber.g:1397:6: lv_theDocString_4_0= ruleDocString
                    {

                    						newCompositeNode(grammarAccess.getWhenAccess().getTheDocStringDocStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theDocString_4_0=ruleDocString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWhenRule());
                    						}
                    						set(
                    							current,
                    							"theDocString",
                    							lv_theDocString_4_0,
                    							"org.farhan.dsl.cucumber.Cucumber.DocString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhen"


    // $ANTLR start "entryRuleThen"
    // InternalCucumber.g:1419:1: entryRuleThen returns [EObject current=null] : iv_ruleThen= ruleThen EOF ;
    public final EObject entryRuleThen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThen = null;


        try {
            // InternalCucumber.g:1419:45: (iv_ruleThen= ruleThen EOF )
            // InternalCucumber.g:1420:2: iv_ruleThen= ruleThen EOF
            {
             newCompositeNode(grammarAccess.getThenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThen=ruleThen();

            state._fsp--;

             current =iv_ruleThen; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThen"


    // $ANTLR start "ruleThen"
    // InternalCucumber.g:1426:1: ruleThen returns [EObject current=null] : (otherlv_0= 'Then' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) ;
    public final EObject ruleThen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_theStepTable_3_0 = null;

        EObject lv_theDocString_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1432:2: ( (otherlv_0= 'Then' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) )
            // InternalCucumber.g:1433:2: (otherlv_0= 'Then' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            {
            // InternalCucumber.g:1433:2: (otherlv_0= 'Then' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            // InternalCucumber.g:1434:3: otherlv_0= 'Then' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getThenAccess().getThenKeyword_0());
            		
            // InternalCucumber.g:1438:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:1439:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:1439:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:1440:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getThenAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getThenRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_22); 

            			newLeafNode(this_EOL_2, grammarAccess.getThenAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:1461:3: ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==17) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_RAWTEXT) ) {
                alt33=2;
            }
            switch (alt33) {
                case 1 :
                    // InternalCucumber.g:1462:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    {
                    // InternalCucumber.g:1462:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    // InternalCucumber.g:1463:5: (lv_theStepTable_3_0= ruleStepTable )
                    {
                    // InternalCucumber.g:1463:5: (lv_theStepTable_3_0= ruleStepTable )
                    // InternalCucumber.g:1464:6: lv_theStepTable_3_0= ruleStepTable
                    {

                    						newCompositeNode(grammarAccess.getThenAccess().getTheStepTableStepTableParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theStepTable_3_0=ruleStepTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getThenRule());
                    						}
                    						set(
                    							current,
                    							"theStepTable",
                    							lv_theStepTable_3_0,
                    							"org.farhan.dsl.cucumber.Cucumber.StepTable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1482:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    {
                    // InternalCucumber.g:1482:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    // InternalCucumber.g:1483:5: (lv_theDocString_4_0= ruleDocString )
                    {
                    // InternalCucumber.g:1483:5: (lv_theDocString_4_0= ruleDocString )
                    // InternalCucumber.g:1484:6: lv_theDocString_4_0= ruleDocString
                    {

                    						newCompositeNode(grammarAccess.getThenAccess().getTheDocStringDocStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theDocString_4_0=ruleDocString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getThenRule());
                    						}
                    						set(
                    							current,
                    							"theDocString",
                    							lv_theDocString_4_0,
                    							"org.farhan.dsl.cucumber.Cucumber.DocString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThen"


    // $ANTLR start "entryRuleAnd"
    // InternalCucumber.g:1506:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalCucumber.g:1506:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalCucumber.g:1507:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalCucumber.g:1513:1: ruleAnd returns [EObject current=null] : (otherlv_0= 'And' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_theStepTable_3_0 = null;

        EObject lv_theDocString_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1519:2: ( (otherlv_0= 'And' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) )
            // InternalCucumber.g:1520:2: (otherlv_0= 'And' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            {
            // InternalCucumber.g:1520:2: (otherlv_0= 'And' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            // InternalCucumber.g:1521:3: otherlv_0= 'And' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAndAccess().getAndKeyword_0());
            		
            // InternalCucumber.g:1525:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:1526:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:1526:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:1527:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getAndAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_22); 

            			newLeafNode(this_EOL_2, grammarAccess.getAndAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:1548:3: ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==17) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_RAWTEXT) ) {
                alt34=2;
            }
            switch (alt34) {
                case 1 :
                    // InternalCucumber.g:1549:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    {
                    // InternalCucumber.g:1549:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    // InternalCucumber.g:1550:5: (lv_theStepTable_3_0= ruleStepTable )
                    {
                    // InternalCucumber.g:1550:5: (lv_theStepTable_3_0= ruleStepTable )
                    // InternalCucumber.g:1551:6: lv_theStepTable_3_0= ruleStepTable
                    {

                    						newCompositeNode(grammarAccess.getAndAccess().getTheStepTableStepTableParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theStepTable_3_0=ruleStepTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndRule());
                    						}
                    						set(
                    							current,
                    							"theStepTable",
                    							lv_theStepTable_3_0,
                    							"org.farhan.dsl.cucumber.Cucumber.StepTable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1569:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    {
                    // InternalCucumber.g:1569:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    // InternalCucumber.g:1570:5: (lv_theDocString_4_0= ruleDocString )
                    {
                    // InternalCucumber.g:1570:5: (lv_theDocString_4_0= ruleDocString )
                    // InternalCucumber.g:1571:6: lv_theDocString_4_0= ruleDocString
                    {

                    						newCompositeNode(grammarAccess.getAndAccess().getTheDocStringDocStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theDocString_4_0=ruleDocString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndRule());
                    						}
                    						set(
                    							current,
                    							"theDocString",
                    							lv_theDocString_4_0,
                    							"org.farhan.dsl.cucumber.Cucumber.DocString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleBut"
    // InternalCucumber.g:1593:1: entryRuleBut returns [EObject current=null] : iv_ruleBut= ruleBut EOF ;
    public final EObject entryRuleBut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBut = null;


        try {
            // InternalCucumber.g:1593:44: (iv_ruleBut= ruleBut EOF )
            // InternalCucumber.g:1594:2: iv_ruleBut= ruleBut EOF
            {
             newCompositeNode(grammarAccess.getButRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBut=ruleBut();

            state._fsp--;

             current =iv_ruleBut; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBut"


    // $ANTLR start "ruleBut"
    // InternalCucumber.g:1600:1: ruleBut returns [EObject current=null] : (otherlv_0= 'But' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) ;
    public final EObject ruleBut() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_theStepTable_3_0 = null;

        EObject lv_theDocString_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1606:2: ( (otherlv_0= 'But' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) )
            // InternalCucumber.g:1607:2: (otherlv_0= 'But' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            {
            // InternalCucumber.g:1607:2: (otherlv_0= 'But' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            // InternalCucumber.g:1608:3: otherlv_0= 'But' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getButAccess().getButKeyword_0());
            		
            // InternalCucumber.g:1612:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:1613:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:1613:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:1614:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getButAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getButRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_22); 

            			newLeafNode(this_EOL_2, grammarAccess.getButAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:1635:3: ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            int alt35=3;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==17) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_RAWTEXT) ) {
                alt35=2;
            }
            switch (alt35) {
                case 1 :
                    // InternalCucumber.g:1636:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    {
                    // InternalCucumber.g:1636:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    // InternalCucumber.g:1637:5: (lv_theStepTable_3_0= ruleStepTable )
                    {
                    // InternalCucumber.g:1637:5: (lv_theStepTable_3_0= ruleStepTable )
                    // InternalCucumber.g:1638:6: lv_theStepTable_3_0= ruleStepTable
                    {

                    						newCompositeNode(grammarAccess.getButAccess().getTheStepTableStepTableParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theStepTable_3_0=ruleStepTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getButRule());
                    						}
                    						set(
                    							current,
                    							"theStepTable",
                    							lv_theStepTable_3_0,
                    							"org.farhan.dsl.cucumber.Cucumber.StepTable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1656:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    {
                    // InternalCucumber.g:1656:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    // InternalCucumber.g:1657:5: (lv_theDocString_4_0= ruleDocString )
                    {
                    // InternalCucumber.g:1657:5: (lv_theDocString_4_0= ruleDocString )
                    // InternalCucumber.g:1658:6: lv_theDocString_4_0= ruleDocString
                    {

                    						newCompositeNode(grammarAccess.getButAccess().getTheDocStringDocStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theDocString_4_0=ruleDocString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getButRule());
                    						}
                    						set(
                    							current,
                    							"theDocString",
                    							lv_theDocString_4_0,
                    							"org.farhan.dsl.cucumber.Cucumber.DocString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBut"


    // $ANTLR start "entryRuleAsterisk"
    // InternalCucumber.g:1680:1: entryRuleAsterisk returns [EObject current=null] : iv_ruleAsterisk= ruleAsterisk EOF ;
    public final EObject entryRuleAsterisk() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsterisk = null;


        try {
            // InternalCucumber.g:1680:49: (iv_ruleAsterisk= ruleAsterisk EOF )
            // InternalCucumber.g:1681:2: iv_ruleAsterisk= ruleAsterisk EOF
            {
             newCompositeNode(grammarAccess.getAsteriskRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAsterisk=ruleAsterisk();

            state._fsp--;

             current =iv_ruleAsterisk; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAsterisk"


    // $ANTLR start "ruleAsterisk"
    // InternalCucumber.g:1687:1: ruleAsterisk returns [EObject current=null] : (otherlv_0= '*' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) ;
    public final EObject ruleAsterisk() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_theStepTable_3_0 = null;

        EObject lv_theDocString_4_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1693:2: ( (otherlv_0= '*' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? ) )
            // InternalCucumber.g:1694:2: (otherlv_0= '*' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            {
            // InternalCucumber.g:1694:2: (otherlv_0= '*' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )? )
            // InternalCucumber.g:1695:3: otherlv_0= '*' ( (lv_name_1_0= ruleTitle ) ) this_EOL_2= RULE_EOL ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAsteriskAccess().getAsteriskKeyword_0());
            		
            // InternalCucumber.g:1699:3: ( (lv_name_1_0= ruleTitle ) )
            // InternalCucumber.g:1700:4: (lv_name_1_0= ruleTitle )
            {
            // InternalCucumber.g:1700:4: (lv_name_1_0= ruleTitle )
            // InternalCucumber.g:1701:5: lv_name_1_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getAsteriskAccess().getNameTitleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAsteriskRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_22); 

            			newLeafNode(this_EOL_2, grammarAccess.getAsteriskAccess().getEOLTerminalRuleCall_2());
            		
            // InternalCucumber.g:1722:3: ( ( (lv_theStepTable_3_0= ruleStepTable ) ) | ( (lv_theDocString_4_0= ruleDocString ) ) )?
            int alt36=3;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==17) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_RAWTEXT) ) {
                alt36=2;
            }
            switch (alt36) {
                case 1 :
                    // InternalCucumber.g:1723:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    {
                    // InternalCucumber.g:1723:4: ( (lv_theStepTable_3_0= ruleStepTable ) )
                    // InternalCucumber.g:1724:5: (lv_theStepTable_3_0= ruleStepTable )
                    {
                    // InternalCucumber.g:1724:5: (lv_theStepTable_3_0= ruleStepTable )
                    // InternalCucumber.g:1725:6: lv_theStepTable_3_0= ruleStepTable
                    {

                    						newCompositeNode(grammarAccess.getAsteriskAccess().getTheStepTableStepTableParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theStepTable_3_0=ruleStepTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAsteriskRule());
                    						}
                    						set(
                    							current,
                    							"theStepTable",
                    							lv_theStepTable_3_0,
                    							"org.farhan.dsl.cucumber.Cucumber.StepTable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1743:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    {
                    // InternalCucumber.g:1743:4: ( (lv_theDocString_4_0= ruleDocString ) )
                    // InternalCucumber.g:1744:5: (lv_theDocString_4_0= ruleDocString )
                    {
                    // InternalCucumber.g:1744:5: (lv_theDocString_4_0= ruleDocString )
                    // InternalCucumber.g:1745:6: lv_theDocString_4_0= ruleDocString
                    {

                    						newCompositeNode(grammarAccess.getAsteriskAccess().getTheDocStringDocStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_theDocString_4_0=ruleDocString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAsteriskRule());
                    						}
                    						set(
                    							current,
                    							"theDocString",
                    							lv_theDocString_4_0,
                    							"org.farhan.dsl.cucumber.Cucumber.DocString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAsterisk"


    // $ANTLR start "entryRuleStatement"
    // InternalCucumber.g:1767:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalCucumber.g:1767:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalCucumber.g:1768:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalCucumber.g:1774:1: ruleStatement returns [EObject current=null] : ( ( (lv_name_0_0= ruleTitle ) ) this_EOL_1= RULE_EOL ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token this_EOL_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalCucumber.g:1780:2: ( ( ( (lv_name_0_0= ruleTitle ) ) this_EOL_1= RULE_EOL ) )
            // InternalCucumber.g:1781:2: ( ( (lv_name_0_0= ruleTitle ) ) this_EOL_1= RULE_EOL )
            {
            // InternalCucumber.g:1781:2: ( ( (lv_name_0_0= ruleTitle ) ) this_EOL_1= RULE_EOL )
            // InternalCucumber.g:1782:3: ( (lv_name_0_0= ruleTitle ) ) this_EOL_1= RULE_EOL
            {
            // InternalCucumber.g:1782:3: ( (lv_name_0_0= ruleTitle ) )
            // InternalCucumber.g:1783:4: (lv_name_0_0= ruleTitle )
            {
            // InternalCucumber.g:1783:4: (lv_name_0_0= ruleTitle )
            // InternalCucumber.g:1784:5: lv_name_0_0= ruleTitle
            {

            					newCompositeNode(grammarAccess.getStatementAccess().getNameTitleParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_0_0=ruleTitle();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStatementRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.farhan.dsl.cucumber.Cucumber.Title");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_2); 

            			newLeafNode(this_EOL_1, grammarAccess.getStatementAccess().getEOLTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleTitle"
    // InternalCucumber.g:1809:1: entryRuleTitle returns [String current=null] : iv_ruleTitle= ruleTitle EOF ;
    public final String entryRuleTitle() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTitle = null;


        try {
            // InternalCucumber.g:1809:45: (iv_ruleTitle= ruleTitle EOF )
            // InternalCucumber.g:1810:2: iv_ruleTitle= ruleTitle EOF
            {
             newCompositeNode(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTitle=ruleTitle();

            state._fsp--;

             current =iv_ruleTitle.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTitle"


    // $ANTLR start "ruleTitle"
    // InternalCucumber.g:1816:1: ruleTitle returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WORD_0= RULE_WORD )+ ;
    public final AntlrDatatypeRuleToken ruleTitle() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WORD_0=null;


        	enterRule();

        try {
            // InternalCucumber.g:1822:2: ( (this_WORD_0= RULE_WORD )+ )
            // InternalCucumber.g:1823:2: (this_WORD_0= RULE_WORD )+
            {
            // InternalCucumber.g:1823:2: (this_WORD_0= RULE_WORD )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_WORD) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalCucumber.g:1824:3: this_WORD_0= RULE_WORD
            	    {
            	    this_WORD_0=(Token)match(input,RULE_WORD,FOLLOW_23); 

            	    			current.merge(this_WORD_0);
            	    		

            	    			newLeafNode(this_WORD_0, grammarAccess.getTitleAccess().getWORDTerminalRuleCall());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTitle"


    // $ANTLR start "entryRuleTag"
    // InternalCucumber.g:1835:1: entryRuleTag returns [EObject current=null] : iv_ruleTag= ruleTag EOF ;
    public final EObject entryRuleTag() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTag = null;


        try {
            // InternalCucumber.g:1835:44: (iv_ruleTag= ruleTag EOF )
            // InternalCucumber.g:1836:2: iv_ruleTag= ruleTag EOF
            {
             newCompositeNode(grammarAccess.getTagRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTag=ruleTag();

            state._fsp--;

             current =iv_ruleTag; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTag"


    // $ANTLR start "ruleTag"
    // InternalCucumber.g:1842:1: ruleTag returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= RULE_WORD ) ) ) ;
    public final EObject ruleTag() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalCucumber.g:1848:2: ( (otherlv_0= '@' ( (lv_name_1_0= RULE_WORD ) ) ) )
            // InternalCucumber.g:1849:2: (otherlv_0= '@' ( (lv_name_1_0= RULE_WORD ) ) )
            {
            // InternalCucumber.g:1849:2: (otherlv_0= '@' ( (lv_name_1_0= RULE_WORD ) ) )
            // InternalCucumber.g:1850:3: otherlv_0= '@' ( (lv_name_1_0= RULE_WORD ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTagAccess().getCommercialAtKeyword_0());
            		
            // InternalCucumber.g:1854:3: ( (lv_name_1_0= RULE_WORD ) )
            // InternalCucumber.g:1855:4: (lv_name_1_0= RULE_WORD )
            {
            // InternalCucumber.g:1855:4: (lv_name_1_0= RULE_WORD )
            // InternalCucumber.g:1856:5: lv_name_1_0= RULE_WORD
            {
            lv_name_1_0=(Token)match(input,RULE_WORD,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTagAccess().getNameWORDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTagRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.cucumber.Cucumber.WORD");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTag"

    // Delegated rules


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\15\1\uffff\1\6\2\uffff\1\4\1\16";
    static final String dfa_3s = "\1\30\1\uffff\1\6\2\uffff\1\30\1\17";
    static final String dfa_4s = "\1\uffff\1\1\1\uffff\1\2\1\3\2\uffff";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\3\1\4\10\uffff\1\2",
            "",
            "\1\5",
            "",
            "",
            "\1\6\23\uffff\1\2",
            "\1\3\1\4"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "511:2: (this_Background_0= ruleBackground | this_Scenario_1= ruleScenario | this_ScenarioOutline_2= ruleScenarioOutline )";
        }
    }
    static final String dfa_7s = "\6\uffff";
    static final String dfa_8s = "\1\1\5\uffff";
    static final String dfa_9s = "\1\15\1\uffff\1\6\1\uffff\1\4\1\16";
    static final String dfa_10s = "\1\30\1\uffff\1\6\1\uffff\1\30\1\20";
    static final String dfa_11s = "\1\uffff\1\2\1\uffff\1\1\2\uffff";
    static final String dfa_12s = "\6\uffff}>";
    static final String[] dfa_13s = {
            "\3\1\1\3\7\uffff\1\2",
            "",
            "\1\4",
            "",
            "\1\5\23\uffff\1\2",
            "\2\1\1\3"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()+ loopback of 840:3: ( (lv_examples_7_0= ruleExamples ) )+";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000442L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000842L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020042L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000100E052L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000100E012L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000FC0042L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000FC0002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001FD0050L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001FD0052L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000020062L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000042L});

}