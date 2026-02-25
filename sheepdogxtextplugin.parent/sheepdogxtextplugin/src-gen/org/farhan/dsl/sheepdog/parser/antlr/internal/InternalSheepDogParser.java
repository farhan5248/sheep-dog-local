package org.farhan.dsl.sheepdog.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSheepDogParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_EOL", "RULE_TEXT_BLOCK", "RULE_WORD", "RULE_WS", "RULE_SL_COMMENT", "'='", "'Step-Object:'", "'=='", "'Step-Definition:'", "'*'", "'Step-Parameters:'", "'Test-Suite:'", "'Test-Setup:'", "'Test-Case:'", "'Test-Data:'", "'+'", "'Given:'", "'When:'", "'Then:'", "'And:'", "'|==='", "'|'", "'file'", "'page'", "'response'", "'dialog'", "'directory'", "'request'", "'goal'", "'job'", "'action'", "'popup'", "'annotation'", "'hover'", "'tooltip'"
    };
    public static final int RULE_WORD=6;
    public static final int RULE_TEXT_BLOCK=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__10=10;
    public static final int T__32=32;
    public static final int T__9=9;
    public static final int RULE_EOL=4;
    public static final int RULE_WS=7;
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


        public InternalSheepDogParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSheepDogParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSheepDogParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSheepDog.g"; }



     	private SheepDogGrammarAccess grammarAccess;

        public InternalSheepDogParser(TokenStream input, SheepDogGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected SheepDogGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalSheepDog.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSheepDog.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalSheepDog.g:65:2: iv_ruleModel= ruleModel EOF
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
    // InternalSheepDog.g:71:1: ruleModel returns [EObject current=null] : (this_StepObject_0= ruleStepObject | this_TestSuite_1= ruleTestSuite ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_StepObject_0 = null;

        EObject this_TestSuite_1 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:77:2: ( (this_StepObject_0= ruleStepObject | this_TestSuite_1= ruleTestSuite ) )
            // InternalSheepDog.g:78:2: (this_StepObject_0= ruleStepObject | this_TestSuite_1= ruleTestSuite )
            {
            // InternalSheepDog.g:78:2: (this_StepObject_0= ruleStepObject | this_TestSuite_1= ruleTestSuite )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==9) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==15) ) {
                    alt1=2;
                }
                else if ( (LA1_1==10) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalSheepDog.g:79:3: this_StepObject_0= ruleStepObject
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
                    // InternalSheepDog.g:88:3: this_TestSuite_1= ruleTestSuite
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getTestSuiteParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TestSuite_1=ruleTestSuite();

                    state._fsp--;


                    			current = this_TestSuite_1;
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
    // InternalSheepDog.g:100:1: entryRuleStepObject returns [EObject current=null] : iv_ruleStepObject= ruleStepObject EOF ;
    public final EObject entryRuleStepObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepObject = null;


        try {
            // InternalSheepDog.g:100:51: (iv_ruleStepObject= ruleStepObject EOF )
            // InternalSheepDog.g:101:2: iv_ruleStepObject= ruleStepObject EOF
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
    // InternalSheepDog.g:107:1: ruleStepObject returns [EObject current=null] : (otherlv_0= '=' otherlv_1= 'Step-Object:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepDefinitionList_5_0= ruleStepDefinition ) )* ) ;
    public final EObject ruleStepObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_description_4_0 = null;

        EObject lv_stepDefinitionList_5_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:113:2: ( (otherlv_0= '=' otherlv_1= 'Step-Object:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepDefinitionList_5_0= ruleStepDefinition ) )* ) )
            // InternalSheepDog.g:114:2: (otherlv_0= '=' otherlv_1= 'Step-Object:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepDefinitionList_5_0= ruleStepDefinition ) )* )
            {
            // InternalSheepDog.g:114:2: (otherlv_0= '=' otherlv_1= 'Step-Object:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepDefinitionList_5_0= ruleStepDefinition ) )* )
            // InternalSheepDog.g:115:3: otherlv_0= '=' otherlv_1= 'Step-Object:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepDefinitionList_5_0= ruleStepDefinition ) )*
            {
            otherlv_0=(Token)match(input,9,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStepObjectAccess().getEqualsSignKeyword_0());
            		
            otherlv_1=(Token)match(input,10,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getStepObjectAccess().getStepObjectKeyword_1());
            		
            // InternalSheepDog.g:123:3: ( (lv_name_2_0= rulePhrase ) )
            // InternalSheepDog.g:124:4: (lv_name_2_0= rulePhrase )
            {
            // InternalSheepDog.g:124:4: (lv_name_2_0= rulePhrase )
            // InternalSheepDog.g:125:5: lv_name_2_0= rulePhrase
            {

            					newCompositeNode(grammarAccess.getStepObjectAccess().getNamePhraseParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=rulePhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepObjectRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Phrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_6); 

            			newLeafNode(this_EOL_3, grammarAccess.getStepObjectAccess().getEOLTerminalRuleCall_3());
            		
            // InternalSheepDog.g:146:3: ( (lv_description_4_0= ruleDescription ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_WORD) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalSheepDog.g:147:4: (lv_description_4_0= ruleDescription )
                    {
                    // InternalSheepDog.g:147:4: (lv_description_4_0= ruleDescription )
                    // InternalSheepDog.g:148:5: lv_description_4_0= ruleDescription
                    {

                    					newCompositeNode(grammarAccess.getStepObjectAccess().getDescriptionDescriptionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_7);
                    lv_description_4_0=ruleDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStepObjectRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_4_0,
                    						"org.farhan.dsl.sheepdog.SheepDog.Description");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSheepDog.g:165:3: ( (lv_stepDefinitionList_5_0= ruleStepDefinition ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSheepDog.g:166:4: (lv_stepDefinitionList_5_0= ruleStepDefinition )
            	    {
            	    // InternalSheepDog.g:166:4: (lv_stepDefinitionList_5_0= ruleStepDefinition )
            	    // InternalSheepDog.g:167:5: lv_stepDefinitionList_5_0= ruleStepDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getStepObjectAccess().getStepDefinitionListStepDefinitionParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_stepDefinitionList_5_0=ruleStepDefinition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStepObjectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"stepDefinitionList",
            	    						lv_stepDefinitionList_5_0,
            	    						"org.farhan.dsl.sheepdog.SheepDog.StepDefinition");
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
    // InternalSheepDog.g:188:1: entryRuleStepDefinition returns [EObject current=null] : iv_ruleStepDefinition= ruleStepDefinition EOF ;
    public final EObject entryRuleStepDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepDefinition = null;


        try {
            // InternalSheepDog.g:188:55: (iv_ruleStepDefinition= ruleStepDefinition EOF )
            // InternalSheepDog.g:189:2: iv_ruleStepDefinition= ruleStepDefinition EOF
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
    // InternalSheepDog.g:195:1: ruleStepDefinition returns [EObject current=null] : (otherlv_0= '==' otherlv_1= 'Step-Definition:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepParameterList_5_0= ruleStepParameters ) )* ) ;
    public final EObject ruleStepDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_description_4_0 = null;

        EObject lv_stepParameterList_5_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:201:2: ( (otherlv_0= '==' otherlv_1= 'Step-Definition:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepParameterList_5_0= ruleStepParameters ) )* ) )
            // InternalSheepDog.g:202:2: (otherlv_0= '==' otherlv_1= 'Step-Definition:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepParameterList_5_0= ruleStepParameters ) )* )
            {
            // InternalSheepDog.g:202:2: (otherlv_0= '==' otherlv_1= 'Step-Definition:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepParameterList_5_0= ruleStepParameters ) )* )
            // InternalSheepDog.g:203:3: otherlv_0= '==' otherlv_1= 'Step-Definition:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_stepParameterList_5_0= ruleStepParameters ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getStepDefinitionAccess().getEqualsSignEqualsSignKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getStepDefinitionAccess().getStepDefinitionKeyword_1());
            		
            // InternalSheepDog.g:211:3: ( (lv_name_2_0= rulePhrase ) )
            // InternalSheepDog.g:212:4: (lv_name_2_0= rulePhrase )
            {
            // InternalSheepDog.g:212:4: (lv_name_2_0= rulePhrase )
            // InternalSheepDog.g:213:5: lv_name_2_0= rulePhrase
            {

            					newCompositeNode(grammarAccess.getStepDefinitionAccess().getNamePhraseParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=rulePhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepDefinitionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Phrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_9); 

            			newLeafNode(this_EOL_3, grammarAccess.getStepDefinitionAccess().getEOLTerminalRuleCall_3());
            		
            // InternalSheepDog.g:234:3: ( (lv_description_4_0= ruleDescription ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_WORD) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalSheepDog.g:235:4: (lv_description_4_0= ruleDescription )
                    {
                    // InternalSheepDog.g:235:4: (lv_description_4_0= ruleDescription )
                    // InternalSheepDog.g:236:5: lv_description_4_0= ruleDescription
                    {

                    					newCompositeNode(grammarAccess.getStepDefinitionAccess().getDescriptionDescriptionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_description_4_0=ruleDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStepDefinitionRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_4_0,
                    						"org.farhan.dsl.sheepdog.SheepDog.Description");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSheepDog.g:253:3: ( (lv_stepParameterList_5_0= ruleStepParameters ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSheepDog.g:254:4: (lv_stepParameterList_5_0= ruleStepParameters )
            	    {
            	    // InternalSheepDog.g:254:4: (lv_stepParameterList_5_0= ruleStepParameters )
            	    // InternalSheepDog.g:255:5: lv_stepParameterList_5_0= ruleStepParameters
            	    {

            	    					newCompositeNode(grammarAccess.getStepDefinitionAccess().getStepParameterListStepParametersParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_stepParameterList_5_0=ruleStepParameters();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStepDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"stepParameterList",
            	    						lv_stepParameterList_5_0,
            	    						"org.farhan.dsl.sheepdog.SheepDog.StepParameters");
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
    // InternalSheepDog.g:276:1: entryRuleStepParameters returns [EObject current=null] : iv_ruleStepParameters= ruleStepParameters EOF ;
    public final EObject entryRuleStepParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepParameters = null;


        try {
            // InternalSheepDog.g:276:55: (iv_ruleStepParameters= ruleStepParameters EOF )
            // InternalSheepDog.g:277:2: iv_ruleStepParameters= ruleStepParameters EOF
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
    // InternalSheepDog.g:283:1: ruleStepParameters returns [EObject current=null] : (otherlv_0= '*' otherlv_1= 'Step-Parameters:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) ) ) ;
    public final EObject ruleStepParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_nestedDescription_4_0 = null;

        EObject lv_table_5_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:289:2: ( (otherlv_0= '*' otherlv_1= 'Step-Parameters:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) ) ) )
            // InternalSheepDog.g:290:2: (otherlv_0= '*' otherlv_1= 'Step-Parameters:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) ) )
            {
            // InternalSheepDog.g:290:2: (otherlv_0= '*' otherlv_1= 'Step-Parameters:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) ) )
            // InternalSheepDog.g:291:3: otherlv_0= '*' otherlv_1= 'Step-Parameters:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getStepParametersAccess().getAsteriskKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getStepParametersAccess().getStepParametersKeyword_1());
            		
            // InternalSheepDog.g:299:3: ( (lv_name_2_0= rulePhrase ) )
            // InternalSheepDog.g:300:4: (lv_name_2_0= rulePhrase )
            {
            // InternalSheepDog.g:300:4: (lv_name_2_0= rulePhrase )
            // InternalSheepDog.g:301:5: lv_name_2_0= rulePhrase
            {

            					newCompositeNode(grammarAccess.getStepParametersAccess().getNamePhraseParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=rulePhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepParametersRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Phrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_12); 

            			newLeafNode(this_EOL_3, grammarAccess.getStepParametersAccess().getEOLTerminalRuleCall_3());
            		
            // InternalSheepDog.g:322:3: ( (lv_nestedDescription_4_0= ruleNestedDescription ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_EOL) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==RULE_WORD) ) {
                        alt6=1;
                    }
                }
            }
            switch (alt6) {
                case 1 :
                    // InternalSheepDog.g:323:4: (lv_nestedDescription_4_0= ruleNestedDescription )
                    {
                    // InternalSheepDog.g:323:4: (lv_nestedDescription_4_0= ruleNestedDescription )
                    // InternalSheepDog.g:324:5: lv_nestedDescription_4_0= ruleNestedDescription
                    {

                    					newCompositeNode(grammarAccess.getStepParametersAccess().getNestedDescriptionNestedDescriptionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_12);
                    lv_nestedDescription_4_0=ruleNestedDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStepParametersRule());
                    					}
                    					set(
                    						current,
                    						"nestedDescription",
                    						lv_nestedDescription_4_0,
                    						"org.farhan.dsl.sheepdog.SheepDog.NestedDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSheepDog.g:341:3: ( (lv_table_5_0= ruleTable ) )
            // InternalSheepDog.g:342:4: (lv_table_5_0= ruleTable )
            {
            // InternalSheepDog.g:342:4: (lv_table_5_0= ruleTable )
            // InternalSheepDog.g:343:5: lv_table_5_0= ruleTable
            {

            					newCompositeNode(grammarAccess.getStepParametersAccess().getTableTableParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_table_5_0=ruleTable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepParametersRule());
            					}
            					set(
            						current,
            						"table",
            						lv_table_5_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Table");
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


    // $ANTLR start "entryRuleTestSuite"
    // InternalSheepDog.g:364:1: entryRuleTestSuite returns [EObject current=null] : iv_ruleTestSuite= ruleTestSuite EOF ;
    public final EObject entryRuleTestSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestSuite = null;


        try {
            // InternalSheepDog.g:364:50: (iv_ruleTestSuite= ruleTestSuite EOF )
            // InternalSheepDog.g:365:2: iv_ruleTestSuite= ruleTestSuite EOF
            {
             newCompositeNode(grammarAccess.getTestSuiteRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestSuite=ruleTestSuite();

            state._fsp--;

             current =iv_ruleTestSuite; 
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
    // $ANTLR end "entryRuleTestSuite"


    // $ANTLR start "ruleTestSuite"
    // InternalSheepDog.g:371:1: ruleTestSuite returns [EObject current=null] : (otherlv_0= '=' otherlv_1= 'Test-Suite:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepContainerList_5_0= ruleTestStepContainer ) )* ) ;
    public final EObject ruleTestSuite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_description_4_0 = null;

        EObject lv_testStepContainerList_5_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:377:2: ( (otherlv_0= '=' otherlv_1= 'Test-Suite:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepContainerList_5_0= ruleTestStepContainer ) )* ) )
            // InternalSheepDog.g:378:2: (otherlv_0= '=' otherlv_1= 'Test-Suite:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepContainerList_5_0= ruleTestStepContainer ) )* )
            {
            // InternalSheepDog.g:378:2: (otherlv_0= '=' otherlv_1= 'Test-Suite:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepContainerList_5_0= ruleTestStepContainer ) )* )
            // InternalSheepDog.g:379:3: otherlv_0= '=' otherlv_1= 'Test-Suite:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepContainerList_5_0= ruleTestStepContainer ) )*
            {
            otherlv_0=(Token)match(input,9,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getTestSuiteAccess().getEqualsSignKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTestSuiteAccess().getTestSuiteKeyword_1());
            		
            // InternalSheepDog.g:387:3: ( (lv_name_2_0= rulePhrase ) )
            // InternalSheepDog.g:388:4: (lv_name_2_0= rulePhrase )
            {
            // InternalSheepDog.g:388:4: (lv_name_2_0= rulePhrase )
            // InternalSheepDog.g:389:5: lv_name_2_0= rulePhrase
            {

            					newCompositeNode(grammarAccess.getTestSuiteAccess().getNamePhraseParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=rulePhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTestSuiteRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Phrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_6); 

            			newLeafNode(this_EOL_3, grammarAccess.getTestSuiteAccess().getEOLTerminalRuleCall_3());
            		
            // InternalSheepDog.g:410:3: ( (lv_description_4_0= ruleDescription ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_WORD) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSheepDog.g:411:4: (lv_description_4_0= ruleDescription )
                    {
                    // InternalSheepDog.g:411:4: (lv_description_4_0= ruleDescription )
                    // InternalSheepDog.g:412:5: lv_description_4_0= ruleDescription
                    {

                    					newCompositeNode(grammarAccess.getTestSuiteAccess().getDescriptionDescriptionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_7);
                    lv_description_4_0=ruleDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTestSuiteRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_4_0,
                    						"org.farhan.dsl.sheepdog.SheepDog.Description");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSheepDog.g:429:3: ( (lv_testStepContainerList_5_0= ruleTestStepContainer ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==11) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSheepDog.g:430:4: (lv_testStepContainerList_5_0= ruleTestStepContainer )
            	    {
            	    // InternalSheepDog.g:430:4: (lv_testStepContainerList_5_0= ruleTestStepContainer )
            	    // InternalSheepDog.g:431:5: lv_testStepContainerList_5_0= ruleTestStepContainer
            	    {

            	    					newCompositeNode(grammarAccess.getTestSuiteAccess().getTestStepContainerListTestStepContainerParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_testStepContainerList_5_0=ruleTestStepContainer();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTestSuiteRule());
            	    					}
            	    					add(
            	    						current,
            	    						"testStepContainerList",
            	    						lv_testStepContainerList_5_0,
            	    						"org.farhan.dsl.sheepdog.SheepDog.TestStepContainer");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleTestSuite"


    // $ANTLR start "entryRuleTestStepContainer"
    // InternalSheepDog.g:452:1: entryRuleTestStepContainer returns [EObject current=null] : iv_ruleTestStepContainer= ruleTestStepContainer EOF ;
    public final EObject entryRuleTestStepContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestStepContainer = null;


        try {
            // InternalSheepDog.g:452:58: (iv_ruleTestStepContainer= ruleTestStepContainer EOF )
            // InternalSheepDog.g:453:2: iv_ruleTestStepContainer= ruleTestStepContainer EOF
            {
             newCompositeNode(grammarAccess.getTestStepContainerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestStepContainer=ruleTestStepContainer();

            state._fsp--;

             current =iv_ruleTestStepContainer; 
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
    // $ANTLR end "entryRuleTestStepContainer"


    // $ANTLR start "ruleTestStepContainer"
    // InternalSheepDog.g:459:1: ruleTestStepContainer returns [EObject current=null] : (this_TestSetup_0= ruleTestSetup | this_TestCase_1= ruleTestCase ) ;
    public final EObject ruleTestStepContainer() throws RecognitionException {
        EObject current = null;

        EObject this_TestSetup_0 = null;

        EObject this_TestCase_1 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:465:2: ( (this_TestSetup_0= ruleTestSetup | this_TestCase_1= ruleTestCase ) )
            // InternalSheepDog.g:466:2: (this_TestSetup_0= ruleTestSetup | this_TestCase_1= ruleTestCase )
            {
            // InternalSheepDog.g:466:2: (this_TestSetup_0= ruleTestSetup | this_TestCase_1= ruleTestCase )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==11) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==17) ) {
                    alt9=2;
                }
                else if ( (LA9_1==16) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalSheepDog.g:467:3: this_TestSetup_0= ruleTestSetup
                    {

                    			newCompositeNode(grammarAccess.getTestStepContainerAccess().getTestSetupParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TestSetup_0=ruleTestSetup();

                    state._fsp--;


                    			current = this_TestSetup_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSheepDog.g:476:3: this_TestCase_1= ruleTestCase
                    {

                    			newCompositeNode(grammarAccess.getTestStepContainerAccess().getTestCaseParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TestCase_1=ruleTestCase();

                    state._fsp--;


                    			current = this_TestCase_1;
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
    // $ANTLR end "ruleTestStepContainer"


    // $ANTLR start "entryRuleTestSetup"
    // InternalSheepDog.g:488:1: entryRuleTestSetup returns [EObject current=null] : iv_ruleTestSetup= ruleTestSetup EOF ;
    public final EObject entryRuleTestSetup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestSetup = null;


        try {
            // InternalSheepDog.g:488:50: (iv_ruleTestSetup= ruleTestSetup EOF )
            // InternalSheepDog.g:489:2: iv_ruleTestSetup= ruleTestSetup EOF
            {
             newCompositeNode(grammarAccess.getTestSetupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestSetup=ruleTestSetup();

            state._fsp--;

             current =iv_ruleTestSetup; 
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
    // $ANTLR end "entryRuleTestSetup"


    // $ANTLR start "ruleTestSetup"
    // InternalSheepDog.g:495:1: ruleTestSetup returns [EObject current=null] : (otherlv_0= '==' otherlv_1= 'Test-Setup:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )* ) ;
    public final EObject ruleTestSetup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_description_4_0 = null;

        EObject lv_testStepList_5_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:501:2: ( (otherlv_0= '==' otherlv_1= 'Test-Setup:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )* ) )
            // InternalSheepDog.g:502:2: (otherlv_0= '==' otherlv_1= 'Test-Setup:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )* )
            {
            // InternalSheepDog.g:502:2: (otherlv_0= '==' otherlv_1= 'Test-Setup:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )* )
            // InternalSheepDog.g:503:3: otherlv_0= '==' otherlv_1= 'Test-Setup:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getTestSetupAccess().getEqualsSignEqualsSignKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTestSetupAccess().getTestSetupKeyword_1());
            		
            // InternalSheepDog.g:511:3: ( (lv_name_2_0= rulePhrase ) )
            // InternalSheepDog.g:512:4: (lv_name_2_0= rulePhrase )
            {
            // InternalSheepDog.g:512:4: (lv_name_2_0= rulePhrase )
            // InternalSheepDog.g:513:5: lv_name_2_0= rulePhrase
            {

            					newCompositeNode(grammarAccess.getTestSetupAccess().getNamePhraseParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=rulePhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTestSetupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Phrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_9); 

            			newLeafNode(this_EOL_3, grammarAccess.getTestSetupAccess().getEOLTerminalRuleCall_3());
            		
            // InternalSheepDog.g:534:3: ( (lv_description_4_0= ruleDescription ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_WORD) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSheepDog.g:535:4: (lv_description_4_0= ruleDescription )
                    {
                    // InternalSheepDog.g:535:4: (lv_description_4_0= ruleDescription )
                    // InternalSheepDog.g:536:5: lv_description_4_0= ruleDescription
                    {

                    					newCompositeNode(grammarAccess.getTestSetupAccess().getDescriptionDescriptionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_description_4_0=ruleDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTestSetupRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_4_0,
                    						"org.farhan.dsl.sheepdog.SheepDog.Description");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSheepDog.g:553:3: ( (lv_testStepList_5_0= ruleTestStep ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==13) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSheepDog.g:554:4: (lv_testStepList_5_0= ruleTestStep )
            	    {
            	    // InternalSheepDog.g:554:4: (lv_testStepList_5_0= ruleTestStep )
            	    // InternalSheepDog.g:555:5: lv_testStepList_5_0= ruleTestStep
            	    {

            	    					newCompositeNode(grammarAccess.getTestSetupAccess().getTestStepListTestStepParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_testStepList_5_0=ruleTestStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTestSetupRule());
            	    					}
            	    					add(
            	    						current,
            	    						"testStepList",
            	    						lv_testStepList_5_0,
            	    						"org.farhan.dsl.sheepdog.SheepDog.TestStep");
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
    // $ANTLR end "ruleTestSetup"


    // $ANTLR start "entryRuleTestCase"
    // InternalSheepDog.g:576:1: entryRuleTestCase returns [EObject current=null] : iv_ruleTestCase= ruleTestCase EOF ;
    public final EObject entryRuleTestCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestCase = null;


        try {
            // InternalSheepDog.g:576:49: (iv_ruleTestCase= ruleTestCase EOF )
            // InternalSheepDog.g:577:2: iv_ruleTestCase= ruleTestCase EOF
            {
             newCompositeNode(grammarAccess.getTestCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestCase=ruleTestCase();

            state._fsp--;

             current =iv_ruleTestCase; 
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
    // $ANTLR end "entryRuleTestCase"


    // $ANTLR start "ruleTestCase"
    // InternalSheepDog.g:583:1: ruleTestCase returns [EObject current=null] : (otherlv_0= '==' otherlv_1= 'Test-Case:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )* ( (lv_testDataList_6_0= ruleTestData ) )* ) ;
    public final EObject ruleTestCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_description_4_0 = null;

        EObject lv_testStepList_5_0 = null;

        EObject lv_testDataList_6_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:589:2: ( (otherlv_0= '==' otherlv_1= 'Test-Case:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )* ( (lv_testDataList_6_0= ruleTestData ) )* ) )
            // InternalSheepDog.g:590:2: (otherlv_0= '==' otherlv_1= 'Test-Case:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )* ( (lv_testDataList_6_0= ruleTestData ) )* )
            {
            // InternalSheepDog.g:590:2: (otherlv_0= '==' otherlv_1= 'Test-Case:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )* ( (lv_testDataList_6_0= ruleTestData ) )* )
            // InternalSheepDog.g:591:3: otherlv_0= '==' otherlv_1= 'Test-Case:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_description_4_0= ruleDescription ) )? ( (lv_testStepList_5_0= ruleTestStep ) )* ( (lv_testDataList_6_0= ruleTestData ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getTestCaseAccess().getEqualsSignEqualsSignKeyword_0());
            		
            otherlv_1=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTestCaseAccess().getTestCaseKeyword_1());
            		
            // InternalSheepDog.g:599:3: ( (lv_name_2_0= rulePhrase ) )
            // InternalSheepDog.g:600:4: (lv_name_2_0= rulePhrase )
            {
            // InternalSheepDog.g:600:4: (lv_name_2_0= rulePhrase )
            // InternalSheepDog.g:601:5: lv_name_2_0= rulePhrase
            {

            					newCompositeNode(grammarAccess.getTestCaseAccess().getNamePhraseParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=rulePhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTestCaseRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Phrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_9); 

            			newLeafNode(this_EOL_3, grammarAccess.getTestCaseAccess().getEOLTerminalRuleCall_3());
            		
            // InternalSheepDog.g:622:3: ( (lv_description_4_0= ruleDescription ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_WORD) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSheepDog.g:623:4: (lv_description_4_0= ruleDescription )
                    {
                    // InternalSheepDog.g:623:4: (lv_description_4_0= ruleDescription )
                    // InternalSheepDog.g:624:5: lv_description_4_0= ruleDescription
                    {

                    					newCompositeNode(grammarAccess.getTestCaseAccess().getDescriptionDescriptionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_description_4_0=ruleDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTestCaseRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_4_0,
                    						"org.farhan.dsl.sheepdog.SheepDog.Description");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSheepDog.g:641:3: ( (lv_testStepList_5_0= ruleTestStep ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==13) ) {
                    int LA13_1 = input.LA(2);

                    if ( ((LA13_1>=20 && LA13_1<=23)) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // InternalSheepDog.g:642:4: (lv_testStepList_5_0= ruleTestStep )
            	    {
            	    // InternalSheepDog.g:642:4: (lv_testStepList_5_0= ruleTestStep )
            	    // InternalSheepDog.g:643:5: lv_testStepList_5_0= ruleTestStep
            	    {

            	    					newCompositeNode(grammarAccess.getTestCaseAccess().getTestStepListTestStepParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_testStepList_5_0=ruleTestStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTestCaseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"testStepList",
            	    						lv_testStepList_5_0,
            	    						"org.farhan.dsl.sheepdog.SheepDog.TestStep");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalSheepDog.g:660:3: ( (lv_testDataList_6_0= ruleTestData ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==13) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSheepDog.g:661:4: (lv_testDataList_6_0= ruleTestData )
            	    {
            	    // InternalSheepDog.g:661:4: (lv_testDataList_6_0= ruleTestData )
            	    // InternalSheepDog.g:662:5: lv_testDataList_6_0= ruleTestData
            	    {

            	    					newCompositeNode(grammarAccess.getTestCaseAccess().getTestDataListTestDataParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_testDataList_6_0=ruleTestData();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTestCaseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"testDataList",
            	    						lv_testDataList_6_0,
            	    						"org.farhan.dsl.sheepdog.SheepDog.TestData");
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
    // $ANTLR end "ruleTestCase"


    // $ANTLR start "entryRuleTestData"
    // InternalSheepDog.g:683:1: entryRuleTestData returns [EObject current=null] : iv_ruleTestData= ruleTestData EOF ;
    public final EObject entryRuleTestData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestData = null;


        try {
            // InternalSheepDog.g:683:49: (iv_ruleTestData= ruleTestData EOF )
            // InternalSheepDog.g:684:2: iv_ruleTestData= ruleTestData EOF
            {
             newCompositeNode(grammarAccess.getTestDataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestData=ruleTestData();

            state._fsp--;

             current =iv_ruleTestData; 
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
    // $ANTLR end "entryRuleTestData"


    // $ANTLR start "ruleTestData"
    // InternalSheepDog.g:690:1: ruleTestData returns [EObject current=null] : (otherlv_0= '*' otherlv_1= 'Test-Data:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) ) ) ;
    public final EObject ruleTestData() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_nestedDescription_4_0 = null;

        EObject lv_table_5_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:696:2: ( (otherlv_0= '*' otherlv_1= 'Test-Data:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) ) ) )
            // InternalSheepDog.g:697:2: (otherlv_0= '*' otherlv_1= 'Test-Data:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) ) )
            {
            // InternalSheepDog.g:697:2: (otherlv_0= '*' otherlv_1= 'Test-Data:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) ) )
            // InternalSheepDog.g:698:3: otherlv_0= '*' otherlv_1= 'Test-Data:' ( (lv_name_2_0= rulePhrase ) ) this_EOL_3= RULE_EOL ( (lv_nestedDescription_4_0= ruleNestedDescription ) )? ( (lv_table_5_0= ruleTable ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getTestDataAccess().getAsteriskKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTestDataAccess().getTestDataKeyword_1());
            		
            // InternalSheepDog.g:706:3: ( (lv_name_2_0= rulePhrase ) )
            // InternalSheepDog.g:707:4: (lv_name_2_0= rulePhrase )
            {
            // InternalSheepDog.g:707:4: (lv_name_2_0= rulePhrase )
            // InternalSheepDog.g:708:5: lv_name_2_0= rulePhrase
            {

            					newCompositeNode(grammarAccess.getTestDataAccess().getNamePhraseParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=rulePhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTestDataRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Phrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_12); 

            			newLeafNode(this_EOL_3, grammarAccess.getTestDataAccess().getEOLTerminalRuleCall_3());
            		
            // InternalSheepDog.g:729:3: ( (lv_nestedDescription_4_0= ruleNestedDescription ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==19) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==RULE_EOL) ) {
                    int LA15_2 = input.LA(3);

                    if ( (LA15_2==RULE_WORD) ) {
                        alt15=1;
                    }
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalSheepDog.g:730:4: (lv_nestedDescription_4_0= ruleNestedDescription )
                    {
                    // InternalSheepDog.g:730:4: (lv_nestedDescription_4_0= ruleNestedDescription )
                    // InternalSheepDog.g:731:5: lv_nestedDescription_4_0= ruleNestedDescription
                    {

                    					newCompositeNode(grammarAccess.getTestDataAccess().getNestedDescriptionNestedDescriptionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_12);
                    lv_nestedDescription_4_0=ruleNestedDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTestDataRule());
                    					}
                    					set(
                    						current,
                    						"nestedDescription",
                    						lv_nestedDescription_4_0,
                    						"org.farhan.dsl.sheepdog.SheepDog.NestedDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSheepDog.g:748:3: ( (lv_table_5_0= ruleTable ) )
            // InternalSheepDog.g:749:4: (lv_table_5_0= ruleTable )
            {
            // InternalSheepDog.g:749:4: (lv_table_5_0= ruleTable )
            // InternalSheepDog.g:750:5: lv_table_5_0= ruleTable
            {

            					newCompositeNode(grammarAccess.getTestDataAccess().getTableTableParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_table_5_0=ruleTable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTestDataRule());
            					}
            					set(
            						current,
            						"table",
            						lv_table_5_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Table");
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
    // $ANTLR end "ruleTestData"


    // $ANTLR start "entryRuleDescription"
    // InternalSheepDog.g:771:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // InternalSheepDog.g:771:52: (iv_ruleDescription= ruleDescription EOF )
            // InternalSheepDog.g:772:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
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
    // $ANTLR end "entryRuleDescription"


    // $ANTLR start "ruleDescription"
    // InternalSheepDog.g:778:1: ruleDescription returns [EObject current=null] : ( (lv_lineList_0_0= ruleLine ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_lineList_0_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:784:2: ( ( (lv_lineList_0_0= ruleLine ) )+ )
            // InternalSheepDog.g:785:2: ( (lv_lineList_0_0= ruleLine ) )+
            {
            // InternalSheepDog.g:785:2: ( (lv_lineList_0_0= ruleLine ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_WORD) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalSheepDog.g:786:3: (lv_lineList_0_0= ruleLine )
            	    {
            	    // InternalSheepDog.g:786:3: (lv_lineList_0_0= ruleLine )
            	    // InternalSheepDog.g:787:4: lv_lineList_0_0= ruleLine
            	    {

            	    				newCompositeNode(grammarAccess.getDescriptionAccess().getLineListLineParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_17);
            	    lv_lineList_0_0=ruleLine();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	    				}
            	    				add(
            	    					current,
            	    					"lineList",
            	    					lv_lineList_0_0,
            	    					"org.farhan.dsl.sheepdog.SheepDog.Line");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleNestedDescription"
    // InternalSheepDog.g:807:1: entryRuleNestedDescription returns [EObject current=null] : iv_ruleNestedDescription= ruleNestedDescription EOF ;
    public final EObject entryRuleNestedDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedDescription = null;


        try {
            // InternalSheepDog.g:807:58: (iv_ruleNestedDescription= ruleNestedDescription EOF )
            // InternalSheepDog.g:808:2: iv_ruleNestedDescription= ruleNestedDescription EOF
            {
             newCompositeNode(grammarAccess.getNestedDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNestedDescription=ruleNestedDescription();

            state._fsp--;

             current =iv_ruleNestedDescription; 
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
    // $ANTLR end "entryRuleNestedDescription"


    // $ANTLR start "ruleNestedDescription"
    // InternalSheepDog.g:814:1: ruleNestedDescription returns [EObject current=null] : (otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_lineList_2_0= ruleLine ) )+ ) ;
    public final EObject ruleNestedDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_1=null;
        EObject lv_lineList_2_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:820:2: ( (otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_lineList_2_0= ruleLine ) )+ ) )
            // InternalSheepDog.g:821:2: (otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_lineList_2_0= ruleLine ) )+ )
            {
            // InternalSheepDog.g:821:2: (otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_lineList_2_0= ruleLine ) )+ )
            // InternalSheepDog.g:822:3: otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_lineList_2_0= ruleLine ) )+
            {
            otherlv_0=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getNestedDescriptionAccess().getPlusSignKeyword_0());
            		
            this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_4); 

            			newLeafNode(this_EOL_1, grammarAccess.getNestedDescriptionAccess().getEOLTerminalRuleCall_1());
            		
            // InternalSheepDog.g:830:3: ( (lv_lineList_2_0= ruleLine ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_WORD) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalSheepDog.g:831:4: (lv_lineList_2_0= ruleLine )
            	    {
            	    // InternalSheepDog.g:831:4: (lv_lineList_2_0= ruleLine )
            	    // InternalSheepDog.g:832:5: lv_lineList_2_0= ruleLine
            	    {

            	    					newCompositeNode(grammarAccess.getNestedDescriptionAccess().getLineListLineParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_lineList_2_0=ruleLine();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNestedDescriptionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"lineList",
            	    						lv_lineList_2_0,
            	    						"org.farhan.dsl.sheepdog.SheepDog.Line");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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
    // $ANTLR end "ruleNestedDescription"


    // $ANTLR start "entryRuleTestStep"
    // InternalSheepDog.g:853:1: entryRuleTestStep returns [EObject current=null] : iv_ruleTestStep= ruleTestStep EOF ;
    public final EObject entryRuleTestStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestStep = null;


        try {
            // InternalSheepDog.g:853:49: (iv_ruleTestStep= ruleTestStep EOF )
            // InternalSheepDog.g:854:2: iv_ruleTestStep= ruleTestStep EOF
            {
             newCompositeNode(grammarAccess.getTestStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestStep=ruleTestStep();

            state._fsp--;

             current =iv_ruleTestStep; 
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
    // $ANTLR end "entryRuleTestStep"


    // $ANTLR start "ruleTestStep"
    // InternalSheepDog.g:860:1: ruleTestStep returns [EObject current=null] : (this_Given_0= ruleGiven | this_When_1= ruleWhen | this_Then_2= ruleThen | this_And_3= ruleAnd ) ;
    public final EObject ruleTestStep() throws RecognitionException {
        EObject current = null;

        EObject this_Given_0 = null;

        EObject this_When_1 = null;

        EObject this_Then_2 = null;

        EObject this_And_3 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:866:2: ( (this_Given_0= ruleGiven | this_When_1= ruleWhen | this_Then_2= ruleThen | this_And_3= ruleAnd ) )
            // InternalSheepDog.g:867:2: (this_Given_0= ruleGiven | this_When_1= ruleWhen | this_Then_2= ruleThen | this_And_3= ruleAnd )
            {
            // InternalSheepDog.g:867:2: (this_Given_0= ruleGiven | this_When_1= ruleWhen | this_Then_2= ruleThen | this_And_3= ruleAnd )
            int alt18=4;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                switch ( input.LA(2) ) {
                case 22:
                    {
                    alt18=3;
                    }
                    break;
                case 20:
                    {
                    alt18=1;
                    }
                    break;
                case 23:
                    {
                    alt18=4;
                    }
                    break;
                case 21:
                    {
                    alt18=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalSheepDog.g:868:3: this_Given_0= ruleGiven
                    {

                    			newCompositeNode(grammarAccess.getTestStepAccess().getGivenParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Given_0=ruleGiven();

                    state._fsp--;


                    			current = this_Given_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSheepDog.g:877:3: this_When_1= ruleWhen
                    {

                    			newCompositeNode(grammarAccess.getTestStepAccess().getWhenParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_When_1=ruleWhen();

                    state._fsp--;


                    			current = this_When_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSheepDog.g:886:3: this_Then_2= ruleThen
                    {

                    			newCompositeNode(grammarAccess.getTestStepAccess().getThenParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Then_2=ruleThen();

                    state._fsp--;


                    			current = this_Then_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSheepDog.g:895:3: this_And_3= ruleAnd
                    {

                    			newCompositeNode(grammarAccess.getTestStepAccess().getAndParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_And_3=ruleAnd();

                    state._fsp--;


                    			current = this_And_3;
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
    // $ANTLR end "ruleTestStep"


    // $ANTLR start "entryRuleGiven"
    // InternalSheepDog.g:907:1: entryRuleGiven returns [EObject current=null] : iv_ruleGiven= ruleGiven EOF ;
    public final EObject entryRuleGiven() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGiven = null;


        try {
            // InternalSheepDog.g:907:46: (iv_ruleGiven= ruleGiven EOF )
            // InternalSheepDog.g:908:2: iv_ruleGiven= ruleGiven EOF
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
    // InternalSheepDog.g:914:1: ruleGiven returns [EObject current=null] : (otherlv_0= '*' otherlv_1= 'Given:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? ) ;
    public final EObject ruleGiven() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_4=null;
        AntlrDatatypeRuleToken lv_stepObjectName_2_0 = null;

        AntlrDatatypeRuleToken lv_stepDefinitionName_3_0 = null;

        EObject lv_table_5_0 = null;

        EObject lv_text_6_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:920:2: ( (otherlv_0= '*' otherlv_1= 'Given:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? ) )
            // InternalSheepDog.g:921:2: (otherlv_0= '*' otherlv_1= 'Given:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? )
            {
            // InternalSheepDog.g:921:2: (otherlv_0= '*' otherlv_1= 'Given:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? )
            // InternalSheepDog.g:922:3: otherlv_0= '*' otherlv_1= 'Given:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getGivenAccess().getAsteriskKeyword_0());
            		
            otherlv_1=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getGivenAccess().getGivenKeyword_1());
            		
            // InternalSheepDog.g:930:3: ( (lv_stepObjectName_2_0= ruleStepObjectRef ) )
            // InternalSheepDog.g:931:4: (lv_stepObjectName_2_0= ruleStepObjectRef )
            {
            // InternalSheepDog.g:931:4: (lv_stepObjectName_2_0= ruleStepObjectRef )
            // InternalSheepDog.g:932:5: lv_stepObjectName_2_0= ruleStepObjectRef
            {

            					newCompositeNode(grammarAccess.getGivenAccess().getStepObjectNameStepObjectRefParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_stepObjectName_2_0=ruleStepObjectRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGivenRule());
            					}
            					set(
            						current,
            						"stepObjectName",
            						lv_stepObjectName_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.StepObjectRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSheepDog.g:949:3: ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) )
            // InternalSheepDog.g:950:4: (lv_stepDefinitionName_3_0= ruleStepDefinitionRef )
            {
            // InternalSheepDog.g:950:4: (lv_stepDefinitionName_3_0= ruleStepDefinitionRef )
            // InternalSheepDog.g:951:5: lv_stepDefinitionName_3_0= ruleStepDefinitionRef
            {

            					newCompositeNode(grammarAccess.getGivenAccess().getStepDefinitionNameStepDefinitionRefParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_5);
            lv_stepDefinitionName_3_0=ruleStepDefinitionRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGivenRule());
            					}
            					set(
            						current,
            						"stepDefinitionName",
            						lv_stepDefinitionName_3_0,
            						"org.farhan.dsl.sheepdog.SheepDog.StepDefinitionRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_19); 

            			newLeafNode(this_EOL_4, grammarAccess.getGivenAccess().getEOLTerminalRuleCall_4());
            		
            // InternalSheepDog.g:972:3: ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )?
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==19) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==RULE_EOL) ) {
                    int LA19_3 = input.LA(3);

                    if ( (LA19_3==RULE_TEXT_BLOCK) ) {
                        alt19=2;
                    }
                    else if ( (LA19_3==24) ) {
                        alt19=1;
                    }
                }
            }
            switch (alt19) {
                case 1 :
                    // InternalSheepDog.g:973:4: ( (lv_table_5_0= ruleTable ) )
                    {
                    // InternalSheepDog.g:973:4: ( (lv_table_5_0= ruleTable ) )
                    // InternalSheepDog.g:974:5: (lv_table_5_0= ruleTable )
                    {
                    // InternalSheepDog.g:974:5: (lv_table_5_0= ruleTable )
                    // InternalSheepDog.g:975:6: lv_table_5_0= ruleTable
                    {

                    						newCompositeNode(grammarAccess.getGivenAccess().getTableTableParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_table_5_0=ruleTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGivenRule());
                    						}
                    						set(
                    							current,
                    							"table",
                    							lv_table_5_0,
                    							"org.farhan.dsl.sheepdog.SheepDog.Table");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSheepDog.g:993:4: ( (lv_text_6_0= ruleText ) )
                    {
                    // InternalSheepDog.g:993:4: ( (lv_text_6_0= ruleText ) )
                    // InternalSheepDog.g:994:5: (lv_text_6_0= ruleText )
                    {
                    // InternalSheepDog.g:994:5: (lv_text_6_0= ruleText )
                    // InternalSheepDog.g:995:6: lv_text_6_0= ruleText
                    {

                    						newCompositeNode(grammarAccess.getGivenAccess().getTextTextParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_text_6_0=ruleText();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGivenRule());
                    						}
                    						set(
                    							current,
                    							"text",
                    							lv_text_6_0,
                    							"org.farhan.dsl.sheepdog.SheepDog.Text");
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
    // InternalSheepDog.g:1017:1: entryRuleWhen returns [EObject current=null] : iv_ruleWhen= ruleWhen EOF ;
    public final EObject entryRuleWhen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhen = null;


        try {
            // InternalSheepDog.g:1017:45: (iv_ruleWhen= ruleWhen EOF )
            // InternalSheepDog.g:1018:2: iv_ruleWhen= ruleWhen EOF
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
    // InternalSheepDog.g:1024:1: ruleWhen returns [EObject current=null] : (otherlv_0= '*' otherlv_1= 'When:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? ) ;
    public final EObject ruleWhen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_4=null;
        AntlrDatatypeRuleToken lv_stepObjectName_2_0 = null;

        AntlrDatatypeRuleToken lv_stepDefinitionName_3_0 = null;

        EObject lv_table_5_0 = null;

        EObject lv_text_6_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:1030:2: ( (otherlv_0= '*' otherlv_1= 'When:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? ) )
            // InternalSheepDog.g:1031:2: (otherlv_0= '*' otherlv_1= 'When:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? )
            {
            // InternalSheepDog.g:1031:2: (otherlv_0= '*' otherlv_1= 'When:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? )
            // InternalSheepDog.g:1032:3: otherlv_0= '*' otherlv_1= 'When:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getWhenAccess().getAsteriskKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getWhenAccess().getWhenKeyword_1());
            		
            // InternalSheepDog.g:1040:3: ( (lv_stepObjectName_2_0= ruleStepObjectRef ) )
            // InternalSheepDog.g:1041:4: (lv_stepObjectName_2_0= ruleStepObjectRef )
            {
            // InternalSheepDog.g:1041:4: (lv_stepObjectName_2_0= ruleStepObjectRef )
            // InternalSheepDog.g:1042:5: lv_stepObjectName_2_0= ruleStepObjectRef
            {

            					newCompositeNode(grammarAccess.getWhenAccess().getStepObjectNameStepObjectRefParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_stepObjectName_2_0=ruleStepObjectRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhenRule());
            					}
            					set(
            						current,
            						"stepObjectName",
            						lv_stepObjectName_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.StepObjectRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSheepDog.g:1059:3: ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) )
            // InternalSheepDog.g:1060:4: (lv_stepDefinitionName_3_0= ruleStepDefinitionRef )
            {
            // InternalSheepDog.g:1060:4: (lv_stepDefinitionName_3_0= ruleStepDefinitionRef )
            // InternalSheepDog.g:1061:5: lv_stepDefinitionName_3_0= ruleStepDefinitionRef
            {

            					newCompositeNode(grammarAccess.getWhenAccess().getStepDefinitionNameStepDefinitionRefParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_5);
            lv_stepDefinitionName_3_0=ruleStepDefinitionRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhenRule());
            					}
            					set(
            						current,
            						"stepDefinitionName",
            						lv_stepDefinitionName_3_0,
            						"org.farhan.dsl.sheepdog.SheepDog.StepDefinitionRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_19); 

            			newLeafNode(this_EOL_4, grammarAccess.getWhenAccess().getEOLTerminalRuleCall_4());
            		
            // InternalSheepDog.g:1082:3: ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )?
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==19) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==RULE_EOL) ) {
                    int LA20_3 = input.LA(3);

                    if ( (LA20_3==RULE_TEXT_BLOCK) ) {
                        alt20=2;
                    }
                    else if ( (LA20_3==24) ) {
                        alt20=1;
                    }
                }
            }
            switch (alt20) {
                case 1 :
                    // InternalSheepDog.g:1083:4: ( (lv_table_5_0= ruleTable ) )
                    {
                    // InternalSheepDog.g:1083:4: ( (lv_table_5_0= ruleTable ) )
                    // InternalSheepDog.g:1084:5: (lv_table_5_0= ruleTable )
                    {
                    // InternalSheepDog.g:1084:5: (lv_table_5_0= ruleTable )
                    // InternalSheepDog.g:1085:6: lv_table_5_0= ruleTable
                    {

                    						newCompositeNode(grammarAccess.getWhenAccess().getTableTableParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_table_5_0=ruleTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWhenRule());
                    						}
                    						set(
                    							current,
                    							"table",
                    							lv_table_5_0,
                    							"org.farhan.dsl.sheepdog.SheepDog.Table");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSheepDog.g:1103:4: ( (lv_text_6_0= ruleText ) )
                    {
                    // InternalSheepDog.g:1103:4: ( (lv_text_6_0= ruleText ) )
                    // InternalSheepDog.g:1104:5: (lv_text_6_0= ruleText )
                    {
                    // InternalSheepDog.g:1104:5: (lv_text_6_0= ruleText )
                    // InternalSheepDog.g:1105:6: lv_text_6_0= ruleText
                    {

                    						newCompositeNode(grammarAccess.getWhenAccess().getTextTextParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_text_6_0=ruleText();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWhenRule());
                    						}
                    						set(
                    							current,
                    							"text",
                    							lv_text_6_0,
                    							"org.farhan.dsl.sheepdog.SheepDog.Text");
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
    // InternalSheepDog.g:1127:1: entryRuleThen returns [EObject current=null] : iv_ruleThen= ruleThen EOF ;
    public final EObject entryRuleThen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThen = null;


        try {
            // InternalSheepDog.g:1127:45: (iv_ruleThen= ruleThen EOF )
            // InternalSheepDog.g:1128:2: iv_ruleThen= ruleThen EOF
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
    // InternalSheepDog.g:1134:1: ruleThen returns [EObject current=null] : (otherlv_0= '*' otherlv_1= 'Then:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? ) ;
    public final EObject ruleThen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_4=null;
        AntlrDatatypeRuleToken lv_stepObjectName_2_0 = null;

        AntlrDatatypeRuleToken lv_stepDefinitionName_3_0 = null;

        EObject lv_table_5_0 = null;

        EObject lv_text_6_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:1140:2: ( (otherlv_0= '*' otherlv_1= 'Then:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? ) )
            // InternalSheepDog.g:1141:2: (otherlv_0= '*' otherlv_1= 'Then:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? )
            {
            // InternalSheepDog.g:1141:2: (otherlv_0= '*' otherlv_1= 'Then:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? )
            // InternalSheepDog.g:1142:3: otherlv_0= '*' otherlv_1= 'Then:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getThenAccess().getAsteriskKeyword_0());
            		
            otherlv_1=(Token)match(input,22,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getThenAccess().getThenKeyword_1());
            		
            // InternalSheepDog.g:1150:3: ( (lv_stepObjectName_2_0= ruleStepObjectRef ) )
            // InternalSheepDog.g:1151:4: (lv_stepObjectName_2_0= ruleStepObjectRef )
            {
            // InternalSheepDog.g:1151:4: (lv_stepObjectName_2_0= ruleStepObjectRef )
            // InternalSheepDog.g:1152:5: lv_stepObjectName_2_0= ruleStepObjectRef
            {

            					newCompositeNode(grammarAccess.getThenAccess().getStepObjectNameStepObjectRefParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_stepObjectName_2_0=ruleStepObjectRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getThenRule());
            					}
            					set(
            						current,
            						"stepObjectName",
            						lv_stepObjectName_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.StepObjectRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSheepDog.g:1169:3: ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) )
            // InternalSheepDog.g:1170:4: (lv_stepDefinitionName_3_0= ruleStepDefinitionRef )
            {
            // InternalSheepDog.g:1170:4: (lv_stepDefinitionName_3_0= ruleStepDefinitionRef )
            // InternalSheepDog.g:1171:5: lv_stepDefinitionName_3_0= ruleStepDefinitionRef
            {

            					newCompositeNode(grammarAccess.getThenAccess().getStepDefinitionNameStepDefinitionRefParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_5);
            lv_stepDefinitionName_3_0=ruleStepDefinitionRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getThenRule());
            					}
            					set(
            						current,
            						"stepDefinitionName",
            						lv_stepDefinitionName_3_0,
            						"org.farhan.dsl.sheepdog.SheepDog.StepDefinitionRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_19); 

            			newLeafNode(this_EOL_4, grammarAccess.getThenAccess().getEOLTerminalRuleCall_4());
            		
            // InternalSheepDog.g:1192:3: ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )?
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==RULE_EOL) ) {
                    int LA21_3 = input.LA(3);

                    if ( (LA21_3==RULE_TEXT_BLOCK) ) {
                        alt21=2;
                    }
                    else if ( (LA21_3==24) ) {
                        alt21=1;
                    }
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalSheepDog.g:1193:4: ( (lv_table_5_0= ruleTable ) )
                    {
                    // InternalSheepDog.g:1193:4: ( (lv_table_5_0= ruleTable ) )
                    // InternalSheepDog.g:1194:5: (lv_table_5_0= ruleTable )
                    {
                    // InternalSheepDog.g:1194:5: (lv_table_5_0= ruleTable )
                    // InternalSheepDog.g:1195:6: lv_table_5_0= ruleTable
                    {

                    						newCompositeNode(grammarAccess.getThenAccess().getTableTableParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_table_5_0=ruleTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getThenRule());
                    						}
                    						set(
                    							current,
                    							"table",
                    							lv_table_5_0,
                    							"org.farhan.dsl.sheepdog.SheepDog.Table");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSheepDog.g:1213:4: ( (lv_text_6_0= ruleText ) )
                    {
                    // InternalSheepDog.g:1213:4: ( (lv_text_6_0= ruleText ) )
                    // InternalSheepDog.g:1214:5: (lv_text_6_0= ruleText )
                    {
                    // InternalSheepDog.g:1214:5: (lv_text_6_0= ruleText )
                    // InternalSheepDog.g:1215:6: lv_text_6_0= ruleText
                    {

                    						newCompositeNode(grammarAccess.getThenAccess().getTextTextParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_text_6_0=ruleText();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getThenRule());
                    						}
                    						set(
                    							current,
                    							"text",
                    							lv_text_6_0,
                    							"org.farhan.dsl.sheepdog.SheepDog.Text");
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
    // InternalSheepDog.g:1237:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalSheepDog.g:1237:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalSheepDog.g:1238:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalSheepDog.g:1244:1: ruleAnd returns [EObject current=null] : (otherlv_0= '*' otherlv_1= 'And:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EOL_4=null;
        AntlrDatatypeRuleToken lv_stepObjectName_2_0 = null;

        AntlrDatatypeRuleToken lv_stepDefinitionName_3_0 = null;

        EObject lv_table_5_0 = null;

        EObject lv_text_6_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:1250:2: ( (otherlv_0= '*' otherlv_1= 'And:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? ) )
            // InternalSheepDog.g:1251:2: (otherlv_0= '*' otherlv_1= 'And:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? )
            {
            // InternalSheepDog.g:1251:2: (otherlv_0= '*' otherlv_1= 'And:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )? )
            // InternalSheepDog.g:1252:3: otherlv_0= '*' otherlv_1= 'And:' ( (lv_stepObjectName_2_0= ruleStepObjectRef ) ) ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) ) this_EOL_4= RULE_EOL ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getAndAccess().getAsteriskKeyword_0());
            		
            otherlv_1=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getAndAccess().getAndKeyword_1());
            		
            // InternalSheepDog.g:1260:3: ( (lv_stepObjectName_2_0= ruleStepObjectRef ) )
            // InternalSheepDog.g:1261:4: (lv_stepObjectName_2_0= ruleStepObjectRef )
            {
            // InternalSheepDog.g:1261:4: (lv_stepObjectName_2_0= ruleStepObjectRef )
            // InternalSheepDog.g:1262:5: lv_stepObjectName_2_0= ruleStepObjectRef
            {

            					newCompositeNode(grammarAccess.getAndAccess().getStepObjectNameStepObjectRefParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_stepObjectName_2_0=ruleStepObjectRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndRule());
            					}
            					set(
            						current,
            						"stepObjectName",
            						lv_stepObjectName_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.StepObjectRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSheepDog.g:1279:3: ( (lv_stepDefinitionName_3_0= ruleStepDefinitionRef ) )
            // InternalSheepDog.g:1280:4: (lv_stepDefinitionName_3_0= ruleStepDefinitionRef )
            {
            // InternalSheepDog.g:1280:4: (lv_stepDefinitionName_3_0= ruleStepDefinitionRef )
            // InternalSheepDog.g:1281:5: lv_stepDefinitionName_3_0= ruleStepDefinitionRef
            {

            					newCompositeNode(grammarAccess.getAndAccess().getStepDefinitionNameStepDefinitionRefParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_5);
            lv_stepDefinitionName_3_0=ruleStepDefinitionRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndRule());
            					}
            					set(
            						current,
            						"stepDefinitionName",
            						lv_stepDefinitionName_3_0,
            						"org.farhan.dsl.sheepdog.SheepDog.StepDefinitionRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_19); 

            			newLeafNode(this_EOL_4, grammarAccess.getAndAccess().getEOLTerminalRuleCall_4());
            		
            // InternalSheepDog.g:1302:3: ( ( (lv_table_5_0= ruleTable ) ) | ( (lv_text_6_0= ruleText ) ) )?
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==RULE_EOL) ) {
                    int LA22_3 = input.LA(3);

                    if ( (LA22_3==RULE_TEXT_BLOCK) ) {
                        alt22=2;
                    }
                    else if ( (LA22_3==24) ) {
                        alt22=1;
                    }
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalSheepDog.g:1303:4: ( (lv_table_5_0= ruleTable ) )
                    {
                    // InternalSheepDog.g:1303:4: ( (lv_table_5_0= ruleTable ) )
                    // InternalSheepDog.g:1304:5: (lv_table_5_0= ruleTable )
                    {
                    // InternalSheepDog.g:1304:5: (lv_table_5_0= ruleTable )
                    // InternalSheepDog.g:1305:6: lv_table_5_0= ruleTable
                    {

                    						newCompositeNode(grammarAccess.getAndAccess().getTableTableParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_table_5_0=ruleTable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndRule());
                    						}
                    						set(
                    							current,
                    							"table",
                    							lv_table_5_0,
                    							"org.farhan.dsl.sheepdog.SheepDog.Table");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSheepDog.g:1323:4: ( (lv_text_6_0= ruleText ) )
                    {
                    // InternalSheepDog.g:1323:4: ( (lv_text_6_0= ruleText ) )
                    // InternalSheepDog.g:1324:5: (lv_text_6_0= ruleText )
                    {
                    // InternalSheepDog.g:1324:5: (lv_text_6_0= ruleText )
                    // InternalSheepDog.g:1325:6: lv_text_6_0= ruleText
                    {

                    						newCompositeNode(grammarAccess.getAndAccess().getTextTextParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_text_6_0=ruleText();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndRule());
                    						}
                    						set(
                    							current,
                    							"text",
                    							lv_text_6_0,
                    							"org.farhan.dsl.sheepdog.SheepDog.Text");
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


    // $ANTLR start "entryRuleText"
    // InternalSheepDog.g:1347:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalSheepDog.g:1347:45: (iv_ruleText= ruleText EOF )
            // InternalSheepDog.g:1348:2: iv_ruleText= ruleText EOF
            {
             newCompositeNode(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleText=ruleText();

            state._fsp--;

             current =iv_ruleText; 
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
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalSheepDog.g:1354:1: ruleText returns [EObject current=null] : (otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_content_2_0= RULE_TEXT_BLOCK ) ) this_EOL_3= RULE_EOL ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_1=null;
        Token lv_content_2_0=null;
        Token this_EOL_3=null;


        	enterRule();

        try {
            // InternalSheepDog.g:1360:2: ( (otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_content_2_0= RULE_TEXT_BLOCK ) ) this_EOL_3= RULE_EOL ) )
            // InternalSheepDog.g:1361:2: (otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_content_2_0= RULE_TEXT_BLOCK ) ) this_EOL_3= RULE_EOL )
            {
            // InternalSheepDog.g:1361:2: (otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_content_2_0= RULE_TEXT_BLOCK ) ) this_EOL_3= RULE_EOL )
            // InternalSheepDog.g:1362:3: otherlv_0= '+' this_EOL_1= RULE_EOL ( (lv_content_2_0= RULE_TEXT_BLOCK ) ) this_EOL_3= RULE_EOL
            {
            otherlv_0=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTextAccess().getPlusSignKeyword_0());
            		
            this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_23); 

            			newLeafNode(this_EOL_1, grammarAccess.getTextAccess().getEOLTerminalRuleCall_1());
            		
            // InternalSheepDog.g:1370:3: ( (lv_content_2_0= RULE_TEXT_BLOCK ) )
            // InternalSheepDog.g:1371:4: (lv_content_2_0= RULE_TEXT_BLOCK )
            {
            // InternalSheepDog.g:1371:4: (lv_content_2_0= RULE_TEXT_BLOCK )
            // InternalSheepDog.g:1372:5: lv_content_2_0= RULE_TEXT_BLOCK
            {
            lv_content_2_0=(Token)match(input,RULE_TEXT_BLOCK,FOLLOW_5); 

            					newLeafNode(lv_content_2_0, grammarAccess.getTextAccess().getContentTEXT_BLOCKTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTextRule());
            					}
            					setWithLastConsumed(
            						current,
            						"content",
            						lv_content_2_0,
            						"org.farhan.dsl.sheepdog.SheepDog.TEXT_BLOCK");
            				

            }


            }

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_2); 

            			newLeafNode(this_EOL_3, grammarAccess.getTextAccess().getEOLTerminalRuleCall_3());
            		

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
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleTable"
    // InternalSheepDog.g:1396:1: entryRuleTable returns [EObject current=null] : iv_ruleTable= ruleTable EOF ;
    public final EObject entryRuleTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTable = null;


        try {
            // InternalSheepDog.g:1396:46: (iv_ruleTable= ruleTable EOF )
            // InternalSheepDog.g:1397:2: iv_ruleTable= ruleTable EOF
            {
             newCompositeNode(grammarAccess.getTableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTable=ruleTable();

            state._fsp--;

             current =iv_ruleTable; 
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
    // $ANTLR end "entryRuleTable"


    // $ANTLR start "ruleTable"
    // InternalSheepDog.g:1403:1: ruleTable returns [EObject current=null] : (otherlv_0= '+' this_EOL_1= RULE_EOL otherlv_2= '|===' this_EOL_3= RULE_EOL ( (lv_rowList_4_0= ruleRow ) )+ otherlv_5= '|===' this_EOL_6= RULE_EOL ) ;
    public final EObject ruleTable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EOL_1=null;
        Token otherlv_2=null;
        Token this_EOL_3=null;
        Token otherlv_5=null;
        Token this_EOL_6=null;
        EObject lv_rowList_4_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:1409:2: ( (otherlv_0= '+' this_EOL_1= RULE_EOL otherlv_2= '|===' this_EOL_3= RULE_EOL ( (lv_rowList_4_0= ruleRow ) )+ otherlv_5= '|===' this_EOL_6= RULE_EOL ) )
            // InternalSheepDog.g:1410:2: (otherlv_0= '+' this_EOL_1= RULE_EOL otherlv_2= '|===' this_EOL_3= RULE_EOL ( (lv_rowList_4_0= ruleRow ) )+ otherlv_5= '|===' this_EOL_6= RULE_EOL )
            {
            // InternalSheepDog.g:1410:2: (otherlv_0= '+' this_EOL_1= RULE_EOL otherlv_2= '|===' this_EOL_3= RULE_EOL ( (lv_rowList_4_0= ruleRow ) )+ otherlv_5= '|===' this_EOL_6= RULE_EOL )
            // InternalSheepDog.g:1411:3: otherlv_0= '+' this_EOL_1= RULE_EOL otherlv_2= '|===' this_EOL_3= RULE_EOL ( (lv_rowList_4_0= ruleRow ) )+ otherlv_5= '|===' this_EOL_6= RULE_EOL
            {
            otherlv_0=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTableAccess().getPlusSignKeyword_0());
            		
            this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_24); 

            			newLeafNode(this_EOL_1, grammarAccess.getTableAccess().getEOLTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getTableAccess().getVerticalLineEqualsSignEqualsSignEqualsSignKeyword_2());
            		
            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_25); 

            			newLeafNode(this_EOL_3, grammarAccess.getTableAccess().getEOLTerminalRuleCall_3());
            		
            // InternalSheepDog.g:1427:3: ( (lv_rowList_4_0= ruleRow ) )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==25) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalSheepDog.g:1428:4: (lv_rowList_4_0= ruleRow )
            	    {
            	    // InternalSheepDog.g:1428:4: (lv_rowList_4_0= ruleRow )
            	    // InternalSheepDog.g:1429:5: lv_rowList_4_0= ruleRow
            	    {

            	    					newCompositeNode(grammarAccess.getTableAccess().getRowListRowParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_26);
            	    lv_rowList_4_0=ruleRow();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTableRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rowList",
            	    						lv_rowList_4_0,
            	    						"org.farhan.dsl.sheepdog.SheepDog.Row");
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

            otherlv_5=(Token)match(input,24,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getTableAccess().getVerticalLineEqualsSignEqualsSignEqualsSignKeyword_5());
            		
            this_EOL_6=(Token)match(input,RULE_EOL,FOLLOW_2); 

            			newLeafNode(this_EOL_6, grammarAccess.getTableAccess().getEOLTerminalRuleCall_6());
            		

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
    // $ANTLR end "ruleTable"


    // $ANTLR start "entryRuleRow"
    // InternalSheepDog.g:1458:1: entryRuleRow returns [EObject current=null] : iv_ruleRow= ruleRow EOF ;
    public final EObject entryRuleRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRow = null;


        try {
            // InternalSheepDog.g:1458:44: (iv_ruleRow= ruleRow EOF )
            // InternalSheepDog.g:1459:2: iv_ruleRow= ruleRow EOF
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
    // InternalSheepDog.g:1465:1: ruleRow returns [EObject current=null] : ( ( (lv_cellList_0_0= ruleCell ) )+ this_EOL_1= RULE_EOL ) ;
    public final EObject ruleRow() throws RecognitionException {
        EObject current = null;

        Token this_EOL_1=null;
        EObject lv_cellList_0_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:1471:2: ( ( ( (lv_cellList_0_0= ruleCell ) )+ this_EOL_1= RULE_EOL ) )
            // InternalSheepDog.g:1472:2: ( ( (lv_cellList_0_0= ruleCell ) )+ this_EOL_1= RULE_EOL )
            {
            // InternalSheepDog.g:1472:2: ( ( (lv_cellList_0_0= ruleCell ) )+ this_EOL_1= RULE_EOL )
            // InternalSheepDog.g:1473:3: ( (lv_cellList_0_0= ruleCell ) )+ this_EOL_1= RULE_EOL
            {
            // InternalSheepDog.g:1473:3: ( (lv_cellList_0_0= ruleCell ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==25) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalSheepDog.g:1474:4: (lv_cellList_0_0= ruleCell )
            	    {
            	    // InternalSheepDog.g:1474:4: (lv_cellList_0_0= ruleCell )
            	    // InternalSheepDog.g:1475:5: lv_cellList_0_0= ruleCell
            	    {

            	    					newCompositeNode(grammarAccess.getRowAccess().getCellListCellParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_cellList_0_0=ruleCell();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRowRule());
            	    					}
            	    					add(
            	    						current,
            	    						"cellList",
            	    						lv_cellList_0_0,
            	    						"org.farhan.dsl.sheepdog.SheepDog.Cell");
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

            this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_2); 

            			newLeafNode(this_EOL_1, grammarAccess.getRowAccess().getEOLTerminalRuleCall_1());
            		

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
    // InternalSheepDog.g:1500:1: entryRuleCell returns [EObject current=null] : iv_ruleCell= ruleCell EOF ;
    public final EObject entryRuleCell() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCell = null;


        try {
            // InternalSheepDog.g:1500:45: (iv_ruleCell= ruleCell EOF )
            // InternalSheepDog.g:1501:2: iv_ruleCell= ruleCell EOF
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
    // InternalSheepDog.g:1507:1: ruleCell returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= rulePhrase ) ) ) ;
    public final EObject ruleCell() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:1513:2: ( (otherlv_0= '|' ( (lv_name_1_0= rulePhrase ) ) ) )
            // InternalSheepDog.g:1514:2: (otherlv_0= '|' ( (lv_name_1_0= rulePhrase ) ) )
            {
            // InternalSheepDog.g:1514:2: (otherlv_0= '|' ( (lv_name_1_0= rulePhrase ) ) )
            // InternalSheepDog.g:1515:3: otherlv_0= '|' ( (lv_name_1_0= rulePhrase ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getCellAccess().getVerticalLineKeyword_0());
            		
            // InternalSheepDog.g:1519:3: ( (lv_name_1_0= rulePhrase ) )
            // InternalSheepDog.g:1520:4: (lv_name_1_0= rulePhrase )
            {
            // InternalSheepDog.g:1520:4: (lv_name_1_0= rulePhrase )
            // InternalSheepDog.g:1521:5: lv_name_1_0= rulePhrase
            {

            					newCompositeNode(grammarAccess.getCellAccess().getNamePhraseParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=rulePhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCellRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Phrase");
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


    // $ANTLR start "entryRuleLine"
    // InternalSheepDog.g:1542:1: entryRuleLine returns [EObject current=null] : iv_ruleLine= ruleLine EOF ;
    public final EObject entryRuleLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLine = null;


        try {
            // InternalSheepDog.g:1542:45: (iv_ruleLine= ruleLine EOF )
            // InternalSheepDog.g:1543:2: iv_ruleLine= ruleLine EOF
            {
             newCompositeNode(grammarAccess.getLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLine=ruleLine();

            state._fsp--;

             current =iv_ruleLine; 
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
    // $ANTLR end "entryRuleLine"


    // $ANTLR start "ruleLine"
    // InternalSheepDog.g:1549:1: ruleLine returns [EObject current=null] : ( ( (lv_content_0_0= rulePhrase ) ) this_EOL_1= RULE_EOL ) ;
    public final EObject ruleLine() throws RecognitionException {
        EObject current = null;

        Token this_EOL_1=null;
        AntlrDatatypeRuleToken lv_content_0_0 = null;



        	enterRule();

        try {
            // InternalSheepDog.g:1555:2: ( ( ( (lv_content_0_0= rulePhrase ) ) this_EOL_1= RULE_EOL ) )
            // InternalSheepDog.g:1556:2: ( ( (lv_content_0_0= rulePhrase ) ) this_EOL_1= RULE_EOL )
            {
            // InternalSheepDog.g:1556:2: ( ( (lv_content_0_0= rulePhrase ) ) this_EOL_1= RULE_EOL )
            // InternalSheepDog.g:1557:3: ( (lv_content_0_0= rulePhrase ) ) this_EOL_1= RULE_EOL
            {
            // InternalSheepDog.g:1557:3: ( (lv_content_0_0= rulePhrase ) )
            // InternalSheepDog.g:1558:4: (lv_content_0_0= rulePhrase )
            {
            // InternalSheepDog.g:1558:4: (lv_content_0_0= rulePhrase )
            // InternalSheepDog.g:1559:5: lv_content_0_0= rulePhrase
            {

            					newCompositeNode(grammarAccess.getLineAccess().getContentPhraseParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_content_0_0=rulePhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLineRule());
            					}
            					set(
            						current,
            						"content",
            						lv_content_0_0,
            						"org.farhan.dsl.sheepdog.SheepDog.Phrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EOL_1=(Token)match(input,RULE_EOL,FOLLOW_2); 

            			newLeafNode(this_EOL_1, grammarAccess.getLineAccess().getEOLTerminalRuleCall_1());
            		

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
    // $ANTLR end "ruleLine"


    // $ANTLR start "entryRulePhrase"
    // InternalSheepDog.g:1584:1: entryRulePhrase returns [String current=null] : iv_rulePhrase= rulePhrase EOF ;
    public final String entryRulePhrase() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePhrase = null;


        try {
            // InternalSheepDog.g:1584:46: (iv_rulePhrase= rulePhrase EOF )
            // InternalSheepDog.g:1585:2: iv_rulePhrase= rulePhrase EOF
            {
             newCompositeNode(grammarAccess.getPhraseRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhrase=rulePhrase();

            state._fsp--;

             current =iv_rulePhrase.getText(); 
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
    // $ANTLR end "entryRulePhrase"


    // $ANTLR start "rulePhrase"
    // InternalSheepDog.g:1591:1: rulePhrase returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WORD_0= RULE_WORD )+ ;
    public final AntlrDatatypeRuleToken rulePhrase() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WORD_0=null;


        	enterRule();

        try {
            // InternalSheepDog.g:1597:2: ( (this_WORD_0= RULE_WORD )+ )
            // InternalSheepDog.g:1598:2: (this_WORD_0= RULE_WORD )+
            {
            // InternalSheepDog.g:1598:2: (this_WORD_0= RULE_WORD )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WORD) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSheepDog.g:1599:3: this_WORD_0= RULE_WORD
            	    {
            	    this_WORD_0=(Token)match(input,RULE_WORD,FOLLOW_17); 

            	    			current.merge(this_WORD_0);
            	    		

            	    			newLeafNode(this_WORD_0, grammarAccess.getPhraseAccess().getWORDTerminalRuleCall());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
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
    // $ANTLR end "rulePhrase"


    // $ANTLR start "entryRuleStepObjectRef"
    // InternalSheepDog.g:1610:1: entryRuleStepObjectRef returns [String current=null] : iv_ruleStepObjectRef= ruleStepObjectRef EOF ;
    public final String entryRuleStepObjectRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStepObjectRef = null;


        try {
            // InternalSheepDog.g:1610:53: (iv_ruleStepObjectRef= ruleStepObjectRef EOF )
            // InternalSheepDog.g:1611:2: iv_ruleStepObjectRef= ruleStepObjectRef EOF
            {
             newCompositeNode(grammarAccess.getStepObjectRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStepObjectRef=ruleStepObjectRef();

            state._fsp--;

             current =iv_ruleStepObjectRef.getText(); 
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
    // $ANTLR end "entryRuleStepObjectRef"


    // $ANTLR start "ruleStepObjectRef"
    // InternalSheepDog.g:1617:1: ruleStepObjectRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WORD_0= RULE_WORD )+ (kw= 'file' | kw= 'page' | kw= 'response' | kw= 'dialog' | kw= 'directory' | kw= 'request' | kw= 'goal' | kw= 'job' | kw= 'action' | kw= 'popup' | kw= 'annotation' | kw= 'hover' | kw= 'tooltip' ) ) ;
    public final AntlrDatatypeRuleToken ruleStepObjectRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WORD_0=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalSheepDog.g:1623:2: ( ( (this_WORD_0= RULE_WORD )+ (kw= 'file' | kw= 'page' | kw= 'response' | kw= 'dialog' | kw= 'directory' | kw= 'request' | kw= 'goal' | kw= 'job' | kw= 'action' | kw= 'popup' | kw= 'annotation' | kw= 'hover' | kw= 'tooltip' ) ) )
            // InternalSheepDog.g:1624:2: ( (this_WORD_0= RULE_WORD )+ (kw= 'file' | kw= 'page' | kw= 'response' | kw= 'dialog' | kw= 'directory' | kw= 'request' | kw= 'goal' | kw= 'job' | kw= 'action' | kw= 'popup' | kw= 'annotation' | kw= 'hover' | kw= 'tooltip' ) )
            {
            // InternalSheepDog.g:1624:2: ( (this_WORD_0= RULE_WORD )+ (kw= 'file' | kw= 'page' | kw= 'response' | kw= 'dialog' | kw= 'directory' | kw= 'request' | kw= 'goal' | kw= 'job' | kw= 'action' | kw= 'popup' | kw= 'annotation' | kw= 'hover' | kw= 'tooltip' ) )
            // InternalSheepDog.g:1625:3: (this_WORD_0= RULE_WORD )+ (kw= 'file' | kw= 'page' | kw= 'response' | kw= 'dialog' | kw= 'directory' | kw= 'request' | kw= 'goal' | kw= 'job' | kw= 'action' | kw= 'popup' | kw= 'annotation' | kw= 'hover' | kw= 'tooltip' )
            {
            // InternalSheepDog.g:1625:3: (this_WORD_0= RULE_WORD )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_WORD) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalSheepDog.g:1626:4: this_WORD_0= RULE_WORD
            	    {
            	    this_WORD_0=(Token)match(input,RULE_WORD,FOLLOW_28); 

            	    				current.merge(this_WORD_0);
            	    			

            	    				newLeafNode(this_WORD_0, grammarAccess.getStepObjectRefAccess().getWORDTerminalRuleCall_0());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            // InternalSheepDog.g:1634:3: (kw= 'file' | kw= 'page' | kw= 'response' | kw= 'dialog' | kw= 'directory' | kw= 'request' | kw= 'goal' | kw= 'job' | kw= 'action' | kw= 'popup' | kw= 'annotation' | kw= 'hover' | kw= 'tooltip' )
            int alt27=13;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt27=1;
                }
                break;
            case 27:
                {
                alt27=2;
                }
                break;
            case 28:
                {
                alt27=3;
                }
                break;
            case 29:
                {
                alt27=4;
                }
                break;
            case 30:
                {
                alt27=5;
                }
                break;
            case 31:
                {
                alt27=6;
                }
                break;
            case 32:
                {
                alt27=7;
                }
                break;
            case 33:
                {
                alt27=8;
                }
                break;
            case 34:
                {
                alt27=9;
                }
                break;
            case 35:
                {
                alt27=10;
                }
                break;
            case 36:
                {
                alt27=11;
                }
                break;
            case 37:
                {
                alt27=12;
                }
                break;
            case 38:
                {
                alt27=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalSheepDog.g:1635:4: kw= 'file'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getFileKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSheepDog.g:1641:4: kw= 'page'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getPageKeyword_1_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalSheepDog.g:1647:4: kw= 'response'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getResponseKeyword_1_2());
                    			

                    }
                    break;
                case 4 :
                    // InternalSheepDog.g:1653:4: kw= 'dialog'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getDialogKeyword_1_3());
                    			

                    }
                    break;
                case 5 :
                    // InternalSheepDog.g:1659:4: kw= 'directory'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getDirectoryKeyword_1_4());
                    			

                    }
                    break;
                case 6 :
                    // InternalSheepDog.g:1665:4: kw= 'request'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getRequestKeyword_1_5());
                    			

                    }
                    break;
                case 7 :
                    // InternalSheepDog.g:1671:4: kw= 'goal'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getGoalKeyword_1_6());
                    			

                    }
                    break;
                case 8 :
                    // InternalSheepDog.g:1677:4: kw= 'job'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getJobKeyword_1_7());
                    			

                    }
                    break;
                case 9 :
                    // InternalSheepDog.g:1683:4: kw= 'action'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getActionKeyword_1_8());
                    			

                    }
                    break;
                case 10 :
                    // InternalSheepDog.g:1689:4: kw= 'popup'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getPopupKeyword_1_9());
                    			

                    }
                    break;
                case 11 :
                    // InternalSheepDog.g:1695:4: kw= 'annotation'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getAnnotationKeyword_1_10());
                    			

                    }
                    break;
                case 12 :
                    // InternalSheepDog.g:1701:4: kw= 'hover'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getHoverKeyword_1_11());
                    			

                    }
                    break;
                case 13 :
                    // InternalSheepDog.g:1707:4: kw= 'tooltip'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getStepObjectRefAccess().getTooltipKeyword_1_12());
                    			

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
    // $ANTLR end "ruleStepObjectRef"


    // $ANTLR start "entryRuleStepDefinitionRef"
    // InternalSheepDog.g:1717:1: entryRuleStepDefinitionRef returns [String current=null] : iv_ruleStepDefinitionRef= ruleStepDefinitionRef EOF ;
    public final String entryRuleStepDefinitionRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStepDefinitionRef = null;


        try {
            // InternalSheepDog.g:1717:57: (iv_ruleStepDefinitionRef= ruleStepDefinitionRef EOF )
            // InternalSheepDog.g:1718:2: iv_ruleStepDefinitionRef= ruleStepDefinitionRef EOF
            {
             newCompositeNode(grammarAccess.getStepDefinitionRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStepDefinitionRef=ruleStepDefinitionRef();

            state._fsp--;

             current =iv_ruleStepDefinitionRef.getText(); 
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
    // $ANTLR end "entryRuleStepDefinitionRef"


    // $ANTLR start "ruleStepDefinitionRef"
    // InternalSheepDog.g:1724:1: ruleStepDefinitionRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WORD_0= RULE_WORD )+ ;
    public final AntlrDatatypeRuleToken ruleStepDefinitionRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WORD_0=null;


        	enterRule();

        try {
            // InternalSheepDog.g:1730:2: ( (this_WORD_0= RULE_WORD )+ )
            // InternalSheepDog.g:1731:2: (this_WORD_0= RULE_WORD )+
            {
            // InternalSheepDog.g:1731:2: (this_WORD_0= RULE_WORD )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_WORD) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalSheepDog.g:1732:3: this_WORD_0= RULE_WORD
            	    {
            	    this_WORD_0=(Token)match(input,RULE_WORD,FOLLOW_17); 

            	    			current.merge(this_WORD_0);
            	    		

            	    			newLeafNode(this_WORD_0, grammarAccess.getStepDefinitionRefAccess().getWORDTerminalRuleCall());
            	    		

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
    // $ANTLR end "ruleStepDefinitionRef"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000842L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002042L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000007FFC000040L});

}