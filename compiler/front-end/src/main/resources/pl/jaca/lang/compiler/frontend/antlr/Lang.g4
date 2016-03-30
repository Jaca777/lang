grammar Lang ;

module :
 ('include' includedModule=QUALIFIED_NAME)*
 'module' name=QUALIFIED_NAME block ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
QUALIFIED_NAME : [a-zA-Z]+ ;

block : '{' statement+ '}' ;

statement
    : initialization      ';' #initializationStatement
    | assignment          ';' #assignmentStatement
    | expr                ';' #exprStatement
    | functionDeclaration ';' #functionDeclarationStatement
    ;

//Function
functionDescriptor
    : name=QUALIFIED_NAME '(' args=formalArguments ')' ':' type=QUALIFIED_NAME
    ;

functionDeclaration
    : 'fun' functionDescriptor '=' block
    ;

initialization
    : 'var' name=QUALIFIED_NAME (':' type=QUALIFIED_NAME)? '=' value=expr
    ;

assignment
    : name=QUALIFIED_NAME '=' value=expr
    ;


//Expression
expr
    : paren                             #parenExpr
    | literal                           #literalExpr
    | reference                         #referenceExpr
    | call                              #callExpr
    | block                             #blockExpr
    | conditional                       #conditionalExpr
    | left=expr op=('*'|'/') right=expr #operatorExpr
    | left=expr op=('+'|'-') right=expr #operatorExpr
    ;



paren : '(' expr ')'  ;

literal
    : INT #intLiteral
    ;

reference : name=QUALIFIED_NAME ;

call : name=QUALIFIED_NAME '(' args=actualArguments ')' ;

conditional : c_if c_elseif* c_else? ;

c_if     : 'if' '(' expr ')' expr         ;
c_elseif : 'else' 'if' '(' expr ')' expr  ;
c_else   : 'else' expr                    ;

actualArguments
    : arguments=expr (',' arguments=expr)*
    ;

formalArguments
    : arguments=formalArgument (',' arguments=formalArgument)*
    ;

formalArgument
    : name=QUALIFIED_NAME ':' type=QUALIFIED_NAME
    ;

INT : [0-9]+ ;