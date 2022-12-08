// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class OptArg implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String optArgName;
    private Assignop Assignop;
    private ConstVal ConstVal;

    public OptArg (Type Type, String optArgName, Assignop Assignop, ConstVal ConstVal) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.optArgName=optArgName;
        this.Assignop=Assignop;
        if(Assignop!=null) Assignop.setParent(this);
        this.ConstVal=ConstVal;
        if(ConstVal!=null) ConstVal.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getOptArgName() {
        return optArgName;
    }

    public void setOptArgName(String optArgName) {
        this.optArgName=optArgName;
    }

    public Assignop getAssignop() {
        return Assignop;
    }

    public void setAssignop(Assignop Assignop) {
        this.Assignop=Assignop;
    }

    public ConstVal getConstVal() {
        return ConstVal;
    }

    public void setConstVal(ConstVal ConstVal) {
        this.ConstVal=ConstVal;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(Assignop!=null) Assignop.accept(visitor);
        if(ConstVal!=null) ConstVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Assignop!=null) Assignop.traverseTopDown(visitor);
        if(ConstVal!=null) ConstVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Assignop!=null) Assignop.traverseBottomUp(visitor);
        if(ConstVal!=null) ConstVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptArg(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+optArgName);
        buffer.append("\n");

        if(Assignop!=null)
            buffer.append(Assignop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstVal!=null)
            buffer.append(ConstVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptArg]");
        return buffer.toString();
    }
}
