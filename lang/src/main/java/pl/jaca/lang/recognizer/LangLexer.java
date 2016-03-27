// Generated from C:/Users/Szymon/Desktop/Programming/lang/interpreter/src/main/resources/pl/jaca/lang\Lang.g4 by ANTLR 4.5.1
package pl.jaca.lang.recognizer;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		WS=18, QUALIFIED_NAME=19, INT=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"WS", "QUALIFIED_NAME", "INT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'module'", "'{'", "'}'", "';'", "'('", "')'", "':'", "'fun'", "'='", 
		"'val'", "'*'", "'/'", "'+'", "'-'", "'if'", "'else'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "WS", "QUALIFIED_NAME", "INT"
	};
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


	public LangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26k\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\6\23\\\n\23\r\23\16\23]\3\23\3\23\3\24"+
		"\6\24c\n\24\r\24\16\24d\3\25\6\25h\n\25\r\25\16\25i\2\2\26\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26\3\2\5\5\2\13\f\17\17\"\"\4\2C\\c|\3\2\62;m\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5\62\3\2\2\2\7\64\3\2\2\2\t\66\3\2"+
		"\2\2\138\3\2\2\2\r:\3\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23B\3\2\2\2\25D\3"+
		"\2\2\2\27H\3\2\2\2\31J\3\2\2\2\33L\3\2\2\2\35N\3\2\2\2\37P\3\2\2\2!S\3"+
		"\2\2\2#X\3\2\2\2%[\3\2\2\2\'b\3\2\2\2)g\3\2\2\2+,\7o\2\2,-\7q\2\2-.\7"+
		"f\2\2./\7w\2\2/\60\7n\2\2\60\61\7g\2\2\61\4\3\2\2\2\62\63\7}\2\2\63\6"+
		"\3\2\2\2\64\65\7\177\2\2\65\b\3\2\2\2\66\67\7=\2\2\67\n\3\2\2\289\7*\2"+
		"\29\f\3\2\2\2:;\7+\2\2;\16\3\2\2\2<=\7<\2\2=\20\3\2\2\2>?\7h\2\2?@\7w"+
		"\2\2@A\7p\2\2A\22\3\2\2\2BC\7?\2\2C\24\3\2\2\2DE\7x\2\2EF\7c\2\2FG\7n"+
		"\2\2G\26\3\2\2\2HI\7,\2\2I\30\3\2\2\2JK\7\61\2\2K\32\3\2\2\2LM\7-\2\2"+
		"M\34\3\2\2\2NO\7/\2\2O\36\3\2\2\2PQ\7k\2\2QR\7h\2\2R \3\2\2\2ST\7g\2\2"+
		"TU\7n\2\2UV\7u\2\2VW\7g\2\2W\"\3\2\2\2XY\7.\2\2Y$\3\2\2\2Z\\\t\2\2\2["+
		"Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b\23\2\2`&\3\2\2"+
		"\2ac\t\3\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e(\3\2\2\2fh\t\4\2"+
		"\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j*\3\2\2\2\6\2]di\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}