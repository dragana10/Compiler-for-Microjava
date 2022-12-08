// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class IfElseStatement extends MatchedStatement {

    private IfConditionPart IfConditionPart;
    private MatchedStatement MatchedStatement;
    private ElsePart ElsePart;
    private MatchedStatement MatchedStatement1;

    public IfElseStatement (IfConditionPart IfConditionPart, MatchedStatement MatchedStatement, ElsePart ElsePart, MatchedStatement MatchedStatement1) {
        this.IfConditionPart=IfConditionPart;
        if(IfConditionPart!=null) IfConditionPart.setParent(this);
        this.MatchedStatement=MatchedStatement;
        if(MatchedStatement!=null) MatchedStatement.setParent(this);
        this.ElsePart=ElsePart;
        if(ElsePart!=null) ElsePart.setParent(this);
        this.MatchedStatement1=MatchedStatement1;
        if(MatchedStatement1!=null) MatchedStatement1.setParent(this);
    }

    public IfConditionPart getIfConditionPart() {
        return IfConditionPart;
    }

    public void setIfConditionPart(IfConditionPart IfConditionPart) {
        this.IfConditionPart=IfConditionPart;
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

    public MatchedStatement getMatchedStatement1() {
        return MatchedStatement1;
    }

    public void setMatchedStatement1(MatchedStatement MatchedStatement1) {
        this.MatchedStatement1=MatchedStatement1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfConditionPart!=null) IfConditionPart.accept(visitor);
        if(MatchedStatement!=null) MatchedStatement.accept(visitor);
        if(ElsePart!=null) ElsePart.accept(visitor);
        if(MatchedStatement1!=null) MatchedStatement1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfConditionPart!=null) IfConditionPart.traverseTopDown(visitor);
        if(MatchedStatement!=null) MatchedStatement.traverseTopDown(visitor);
        if(ElsePart!=null) ElsePart.traverseTopDown(visitor);
        if(MatchedStatement1!=null) MatchedStatement1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfConditionPart!=null) IfConditionPart.traverseBottomUp(visitor);
        if(MatchedStatement!=null) MatchedStatement.traverseBottomUp(visitor);
        if(ElsePart!=null) ElsePart.traverseBottomUp(visitor);
        if(MatchedStatement1!=null) MatchedStatement1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfElseStatement(\n");

        if(IfConditionPart!=null)
            buffer.append(IfConditionPart.toString("  "+tab));
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

        if(MatchedStatement1!=null)
            buffer.append(MatchedStatement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfElseStatement]");
        return buffer.toString();
    }
}
