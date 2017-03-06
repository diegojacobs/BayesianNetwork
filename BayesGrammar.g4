grammar BayesGrammar;


fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9' ;

NEGATION: '!';
TOKEN:   LETTER  ;
NUM : DIGIT ('.'? DIGIT* )? ;
EQUALS: '=';

WhiteSpace: [\t\r\n\f ]+ -> skip;

COMMENT: ( '//' ~[\r\n]* '\r'? '\n' | '/*' .*? '*/') -> skip;								
    
program: probability+;

probability: 'P' '(' op (condition  op2)?  ')' EQUALS number;

number: NUM;

condition: ('|'); 
negation: NEGATION;
operator: negation? TOKEN (',')?;
op: operator* ;
op2: operator2*;
operator2: negation? TOKEN (',')?;

cliBayes: expression+;

expression: 'P' '(' op (condition  op2)?  ')';