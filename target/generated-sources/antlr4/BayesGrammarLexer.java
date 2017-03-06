// Generated from BayesGrammar.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BayesGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, NEGATION=6, TOKEN=7, NUM=8, EQUALS=9, 
		WhiteSpace=10, COMMENT=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "LETTER", "DIGIT", "NEGATION", 
		"TOKEN", "NUM", "EQUALS", "WhiteSpace", "COMMENT"
	};


	public BayesGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BayesGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\r`\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\5\13\62\n\13\3\13\7\13\65\n"+
		"\13\f\13\16\138\13\13\5\13:\n\13\3\f\3\f\3\r\6\r?\n\r\r\r\16\r@\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\7\16I\n\16\f\16\16\16L\13\16\3\16\5\16O\n\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16V\n\16\f\16\16\16Y\13\16\3\16\3\16\5\16]\n"+
		"\16\3\16\3\16\3W\2\17\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\b\23\t\25\n\27"+
		"\13\31\f\33\r\3\2\5\4\2C\\c|\5\2\13\f\16\17\"\"\4\2\f\f\17\17e\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2"+
		"\2\2\5\37\3\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r\'\3\2\2\2\17)\3"+
		"\2\2\2\21+\3\2\2\2\23-\3\2\2\2\25/\3\2\2\2\27;\3\2\2\2\31>\3\2\2\2\33"+
		"\\\3\2\2\2\35\36\7R\2\2\36\4\3\2\2\2\37 \7*\2\2 \6\3\2\2\2!\"\7+\2\2\""+
		"\b\3\2\2\2#$\7.\2\2$\n\3\2\2\2%&\7~\2\2&\f\3\2\2\2\'(\t\2\2\2(\16\3\2"+
		"\2\2)*\4\62;\2*\20\3\2\2\2+,\7#\2\2,\22\3\2\2\2-.\5\r\7\2.\24\3\2\2\2"+
		"/9\5\17\b\2\60\62\7\60\2\2\61\60\3\2\2\2\61\62\3\2\2\2\62\66\3\2\2\2\63"+
		"\65\5\17\b\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67"+
		":\3\2\2\28\66\3\2\2\29\61\3\2\2\29:\3\2\2\2:\26\3\2\2\2;<\7?\2\2<\30\3"+
		"\2\2\2=?\t\3\2\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\b"+
		"\r\2\2C\32\3\2\2\2DE\7\61\2\2EF\7\61\2\2FJ\3\2\2\2GI\n\4\2\2HG\3\2\2\2"+
		"IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2MO\7\17\2\2NM\3\2\2"+
		"\2NO\3\2\2\2OP\3\2\2\2P]\7\f\2\2QR\7\61\2\2RS\7,\2\2SW\3\2\2\2TV\13\2"+
		"\2\2UT\3\2\2\2VY\3\2\2\2WX\3\2\2\2WU\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7,"+
		"\2\2[]\7\61\2\2\\D\3\2\2\2\\Q\3\2\2\2]^\3\2\2\2^_\b\16\2\2_\34\3\2\2\2"+
		"\13\2\61\669@JNW\\\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}