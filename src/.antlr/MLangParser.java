// Generated from /Users/muditgolchha/Desktop/MLANG/src/MLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, ID=28, INT=29, WS=30;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_letDecl = 2, RULE_assignStmt = 3, 
		RULE_exprStmt = 4, RULE_ifStmt = 5, RULE_whileStmt = 6, RULE_showStmt = 7, 
		RULE_funcDecl = 8, RULE_returnStmt = 9, RULE_block = 10, RULE_params = 11, 
		RULE_param = 12, RULE_arguments = 13, RULE_expr = 14, RULE_type = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "letDecl", "assignStmt", "exprStmt", "ifStmt", "whileStmt", 
			"showStmt", "funcDecl", "returnStmt", "block", "params", "param", "arguments", 
			"expr", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'>'", "'='", "';'", "'if'", "'('", "')'", "'else'", "'while'", 
			"'show'", "'func'", "'return'", "'['", "']'", "','", "'=='", "'!='", 
			"'<'", "'<='", "'>='", "'*'", "'/'", "'+'", "'-'", "'int'", "'float'", 
			"'bool'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ID", "INT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MLangParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 805314082L) != 0)) {
				{
				{
				setState(32);
				stmt();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public LetDeclContext letDecl() {
			return getRuleContext(LetDeclContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ShowStmtContext showStmt() {
			return getRuleContext(ShowStmtContext.class,0);
		}
		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				letDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				assignStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				exprStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				whileStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				showStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(46);
				funcDecl();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(47);
				returnStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MLangParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LetDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDecl; }
	}

	public final LetDeclContext letDecl() throws RecognitionException {
		LetDeclContext _localctx = new LetDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_letDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			match(ID);
			setState(52);
			match(T__1);
			setState(53);
			type();
			setState(54);
			match(T__2);
			setState(55);
			expr(0);
			setState(56);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MLangParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(ID);
			setState(59);
			match(T__2);
			setState(60);
			expr(0);
			setState(61);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			expr(0);
			setState(64);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__4);
			setState(67);
			match(T__5);
			setState(68);
			expr(0);
			setState(69);
			match(T__6);
			setState(70);
			block();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(71);
				match(T__7);
				setState(72);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__8);
			setState(76);
			match(T__5);
			setState(77);
			expr(0);
			setState(78);
			match(T__6);
			setState(79);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShowStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ShowStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showStmt; }
	}

	public final ShowStmtContext showStmt() throws RecognitionException {
		ShowStmtContext _localctx = new ShowStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_showStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__9);
			setState(82);
			match(T__5);
			setState(83);
			expr(0);
			setState(84);
			match(T__6);
			setState(85);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MLangParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__10);
			setState(88);
			match(ID);
			setState(89);
			match(T__5);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(90);
				params();
				}
			}

			setState(93);
			match(T__6);
			setState(94);
			match(T__1);
			setState(95);
			type();
			setState(96);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__11);
			setState(99);
			expr(0);
			setState(100);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__12);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 805314082L) != 0)) {
				{
				{
				setState(103);
				stmt();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			param();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(112);
				match(T__14);
				setState(113);
				param();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MLangParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(ID);
			setState(120);
			match(T__1);
			setState(121);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			expr(0);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(124);
				match(T__14);
				setState(125);
				expr(0);
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(MLangParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntLiteralContext extends ExprContext {
		public TerminalNode INT() { return getToken(MLangParser.INT, 0); }
		public IntLiteralContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(MLangParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FuncCallExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new FuncCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(132);
				match(ID);
				setState(133);
				match(T__5);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID || _la==INT) {
					{
					setState(134);
					arguments();
					}
				}

				setState(137);
				match(T__6);
				}
				break;
			case 2:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				match(INT);
				}
				break;
			case 3:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(151);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(143);
						((CompExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2031620L) != 0)) ) {
							((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(144);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(146);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(147);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(148);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(149);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(150);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u009f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005J\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\\\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005"+
		"\ni\b\n\n\n\f\nl\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000bs\b\u000b\n\u000b\f\u000bv\t\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u007f\b\r\n\r\f\r\u0082\t\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0088\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u008d\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u0098\b\u000e\n\u000e\f\u000e\u009b\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0001\u001c\u0010\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		"\u0000\u0004\u0002\u0000\u0002\u0002\u0010\u0014\u0001\u0000\u0015\u0016"+
		"\u0001\u0000\u0017\u0018\u0001\u0000\u0019\u001b\u00a1\u0000#\u0001\u0000"+
		"\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000\u0000"+
		"\u0006:\u0001\u0000\u0000\u0000\b?\u0001\u0000\u0000\u0000\nB\u0001\u0000"+
		"\u0000\u0000\fK\u0001\u0000\u0000\u0000\u000eQ\u0001\u0000\u0000\u0000"+
		"\u0010W\u0001\u0000\u0000\u0000\u0012b\u0001\u0000\u0000\u0000\u0014f"+
		"\u0001\u0000\u0000\u0000\u0016o\u0001\u0000\u0000\u0000\u0018w\u0001\u0000"+
		"\u0000\u0000\u001a{\u0001\u0000\u0000\u0000\u001c\u008c\u0001\u0000\u0000"+
		"\u0000\u001e\u009c\u0001\u0000\u0000\u0000 \"\u0003\u0002\u0001\u0000"+
		"! \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000\u0000%#\u0001\u0000"+
		"\u0000\u0000&\'\u0005\u0000\u0000\u0001\'\u0001\u0001\u0000\u0000\u0000"+
		"(1\u0003\u0004\u0002\u0000)1\u0003\u0006\u0003\u0000*1\u0003\b\u0004\u0000"+
		"+1\u0003\n\u0005\u0000,1\u0003\f\u0006\u0000-1\u0003\u000e\u0007\u0000"+
		".1\u0003\u0010\b\u0000/1\u0003\u0012\t\u00000(\u0001\u0000\u0000\u0000"+
		"0)\u0001\u0000\u0000\u00000*\u0001\u0000\u0000\u00000+\u0001\u0000\u0000"+
		"\u00000,\u0001\u0000\u0000\u00000-\u0001\u0000\u0000\u00000.\u0001\u0000"+
		"\u0000\u00000/\u0001\u0000\u0000\u00001\u0003\u0001\u0000\u0000\u0000"+
		"23\u0005\u0001\u0000\u000034\u0005\u001c\u0000\u000045\u0005\u0002\u0000"+
		"\u000056\u0003\u001e\u000f\u000067\u0005\u0003\u0000\u000078\u0003\u001c"+
		"\u000e\u000089\u0005\u0004\u0000\u00009\u0005\u0001\u0000\u0000\u0000"+
		":;\u0005\u001c\u0000\u0000;<\u0005\u0003\u0000\u0000<=\u0003\u001c\u000e"+
		"\u0000=>\u0005\u0004\u0000\u0000>\u0007\u0001\u0000\u0000\u0000?@\u0003"+
		"\u001c\u000e\u0000@A\u0005\u0004\u0000\u0000A\t\u0001\u0000\u0000\u0000"+
		"BC\u0005\u0005\u0000\u0000CD\u0005\u0006\u0000\u0000DE\u0003\u001c\u000e"+
		"\u0000EF\u0005\u0007\u0000\u0000FI\u0003\u0014\n\u0000GH\u0005\b\u0000"+
		"\u0000HJ\u0003\u0014\n\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000J\u000b\u0001\u0000\u0000\u0000KL\u0005\t\u0000\u0000LM\u0005\u0006"+
		"\u0000\u0000MN\u0003\u001c\u000e\u0000NO\u0005\u0007\u0000\u0000OP\u0003"+
		"\u0014\n\u0000P\r\u0001\u0000\u0000\u0000QR\u0005\n\u0000\u0000RS\u0005"+
		"\u0006\u0000\u0000ST\u0003\u001c\u000e\u0000TU\u0005\u0007\u0000\u0000"+
		"UV\u0005\u0004\u0000\u0000V\u000f\u0001\u0000\u0000\u0000WX\u0005\u000b"+
		"\u0000\u0000XY\u0005\u001c\u0000\u0000Y[\u0005\u0006\u0000\u0000Z\\\u0003"+
		"\u0016\u000b\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\]\u0001\u0000\u0000\u0000]^\u0005\u0007\u0000\u0000^_\u0005\u0002\u0000"+
		"\u0000_`\u0003\u001e\u000f\u0000`a\u0003\u0014\n\u0000a\u0011\u0001\u0000"+
		"\u0000\u0000bc\u0005\f\u0000\u0000cd\u0003\u001c\u000e\u0000de\u0005\u0004"+
		"\u0000\u0000e\u0013\u0001\u0000\u0000\u0000fj\u0005\r\u0000\u0000gi\u0003"+
		"\u0002\u0001\u0000hg\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000"+
		"\u0000lj\u0001\u0000\u0000\u0000mn\u0005\u000e\u0000\u0000n\u0015\u0001"+
		"\u0000\u0000\u0000ot\u0003\u0018\f\u0000pq\u0005\u000f\u0000\u0000qs\u0003"+
		"\u0018\f\u0000rp\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u\u0017\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000wx\u0005\u001c\u0000\u0000xy\u0005\u0002"+
		"\u0000\u0000yz\u0003\u001e\u000f\u0000z\u0019\u0001\u0000\u0000\u0000"+
		"{\u0080\u0003\u001c\u000e\u0000|}\u0005\u000f\u0000\u0000}\u007f\u0003"+
		"\u001c\u000e\u0000~|\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u001b\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0006\u000e\uffff\uffff\u0000\u0084\u0085\u0005\u001c\u0000"+
		"\u0000\u0085\u0087\u0005\u0006\u0000\u0000\u0086\u0088\u0003\u001a\r\u0000"+
		"\u0087\u0086\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008d\u0005\u0007\u0000\u0000"+
		"\u008a\u008d\u0005\u001d\u0000\u0000\u008b\u008d\u0005\u001c\u0000\u0000"+
		"\u008c\u0083\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000"+
		"\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u0099\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\n\u0006\u0000\u0000\u008f\u0090\u0007\u0000\u0000\u0000\u0090"+
		"\u0098\u0003\u001c\u000e\u0007\u0091\u0092\n\u0005\u0000\u0000\u0092\u0093"+
		"\u0007\u0001\u0000\u0000\u0093\u0098\u0003\u001c\u000e\u0006\u0094\u0095"+
		"\n\u0004\u0000\u0000\u0095\u0096\u0007\u0002\u0000\u0000\u0096\u0098\u0003"+
		"\u001c\u000e\u0005\u0097\u008e\u0001\u0000\u0000\u0000\u0097\u0091\u0001"+
		"\u0000\u0000\u0000\u0097\u0094\u0001\u0000\u0000\u0000\u0098\u009b\u0001"+
		"\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001"+
		"\u0000\u0000\u0000\u009a\u001d\u0001\u0000\u0000\u0000\u009b\u0099\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0007\u0003\u0000\u0000\u009d\u001f\u0001"+
		"\u0000\u0000\u0000\u000b#0I[jt\u0080\u0087\u008c\u0097\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}