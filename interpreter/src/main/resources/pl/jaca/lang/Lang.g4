grammar Lang ;

module : 'module' name=QUALIFIED_NAME block ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
QUALIFIED_NAME : [a-zA-Z]+ ;

block : '{' statement+ '}' ;

statement
    : initialization     ';'
    | assignment         ';'
    | conditional        ';'
    | expr               ';'
    | functionDeclaration ';'
    ;

//Function
functionDescriptor
    : name=QUALIFIED_NAME '(' args=formalArguments ')' ':' type=QUALIFIED_NAME
    ;

functionDeclaration
    : 'fun' functionDescriptor '=' block
    ;

initialization
    : 'val' name=QUALIFIED_NAME ':' type=QUALIFIED_NAME '=' value=expr
    ;

assignment
    : name=QUALIFIED_NAME '=' value=expr
    ;

//If
conditional
    : 'if' '(' expr ')' expr
    ( 'else' 'if' '(' expr ')' expr )*
    ( 'else' expr)?
    ;

//Expression
expr
    : left=expr op=('*'|'/') right=expr                     #opExpr
    | left=expr op=('+'|'-') right=expr                     #opExpr
    | '(' expr ')'                                          #parenExpr
    | INT                                                   #atomExpr
    | ref=QUALIFIED_NAME                                    #refExpr
    | name=QUALIFIED_NAME '(' args=actualArguments ')'      #call
    ;

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