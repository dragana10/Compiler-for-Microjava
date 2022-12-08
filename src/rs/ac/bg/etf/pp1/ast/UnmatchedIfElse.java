// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedIfElse extends UnmatchedStatement {

    private IfPart IfPart;
    private MatchedStatement MatchedStatement;
    private ElsePart ElsePart;
    private UnmatchedStatement UnmatchedStatement;

    public UnmatchedIfElse (IfPart IfPart, MatchedStatement MatchedStatement, ElsePart ElsePart, UnmatchedStatement UnmatchedStatement) {
        this.IfPart=IfPart;
        if(IfPart!=null) IfPart.setParent(this);
        this.MatchedStatement=MatchedStatement;
        if(MatchedStatement!=null) MatchedStatement.setParent(this);
        this.ElsePart=ElsePart;
        if(ElsePart!=null) ElsePart.setParent(this);
        this.UnmatchedStatement=UnmatchedStatement;
        if(UnmatchedStatement!=null) UnmatchedStatement.setParent(this);
    }

    public IfPart getIfPart() {
        return IfPart;
    }

    public void setIfPart(IfPart IfPart) {
        this.IfPart=IfPart;
    }

    public MatchedStatement getMatchedStatement() {
        return MatchedStatement;
    }

    public void setMatchedStatement(MatchedStatement MatchedStatement) {
        this.MatchedStatement=MatchedStatement;
    }

    public ElsePart getElsePart() {
        return ElsePart;
    }

    public void setElsePart(ElsePart ElsePart) {
        this.ElsePart=ElsePart;
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
        if(IfPart!=null) IfPart.accept(visitor);
        if(MatchedStatement!=null) MatchedStatement.accept(visitor);
        if(ElsePart!=null) ElsePart.accept(visitor);
        if(UnmatchedStatement!=null) UnmatchedStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfPart!=null) IfPart.traverseTopDown(visitor);
        if(MatchedStatement!=null) MatchedStatement.traverseTopDown(visitor);
        if(ElsePart!=null) ElsePart.traverseTopDown(visitor);
        if(UnmatchedStatement!=null) UnmatchedStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfPart!=null) IfPart.traverseBottomUp(visitor);
        if(MatchedStatement!=null) MatchedStatement.traverseBottomUp(visitor);
        if(ElsePart!=null) ElsePart.traverseBottomUp(visitor);
        if(UnmatchedStatement!=null) UnmatchedStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIfElse(\n");

        if(IfPart!=null)
            buffer.append(IfPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MatchedStatement!=null)
            buffer.append(MatchedStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElsePart!=null)
            buffer.append(ElsePart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(UnmatchedStatement!=null)
            buffer.append(UnmatchedStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIfElse]");
        return buffer.toString();
    }
}
