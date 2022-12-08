// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedStatementClass extends SingleStatement {

    private UnmatchedStatement UnmatchedStatement;

    public UnmatchedStatementClass (UnmatchedStatement UnmatchedStatement) {
        this.UnmatchedStatement=UnmatchedStatement;
        if(UnmatchedStatement!=null) UnmatchedStatement.setParent(this);
    }

    public UnmatchedStatement getUnmatchedStatement() {
        return UnmatchedStatement;
    }

    public void setUnmatchedStatement(UnmatchedStatement UnmatchedStatement) {
        this.UnmatchedStatement=UnmatchedStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(UnmatchedStatement!=null) UnmatchedStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(UnmatchedStatement!=null) UnmatchedStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(UnmatchedStatement!=null) UnmatchedStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedStatementClass(\n");

        if(UnmatchedStatement!=null)
            buffer.append(UnmatchedStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedStatementClass]");
        return buffer.toString();
    }
}
