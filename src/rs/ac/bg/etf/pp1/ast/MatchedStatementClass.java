// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class MatchedStatementClass extends SingleStatement {

    private MatchedStatement MatchedStatement;

    public MatchedStatementClass (MatchedStatement MatchedStatement) {
        this.MatchedStatement=MatchedStatement;
        if(MatchedStatement!=null) MatchedStatement.setParent(this);
    }

    public MatchedStatement getMatchedStatement() {
        return MatchedStatement;
    }

    public void setMatchedStatement(MatchedStatement MatchedStatement) {
        this.MatchedStatement=MatchedStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MatchedStatement!=null) MatchedStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MatchedStatement!=null) MatchedStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MatchedStatement!=null) MatchedStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedStatementClass(\n");

        if(MatchedStatement!=null)
            buffer.append(MatchedStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedStatementClass]");
        return buffer.toString();
    }
}
