// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class GoToStatement extends MatchedStatement {

    private GotoPart GotoPart;
    private Label Label;

    public GoToStatement (GotoPart GotoPart, Label Label) {
        this.GotoPart=GotoPart;
        if(GotoPart!=null) GotoPart.setParent(this);
        this.Label=Label;
        if(Label!=null) Label.setParent(this);
    }

    public GotoPart getGotoPart() {
        return GotoPart;
    }

    public void setGotoPart(GotoPart GotoPart) {
        this.GotoPart=GotoPart;
    }

    public Label getLabel() {
        return Label;
    }

    public void setLabel(Label Label) {
        this.Label=Label;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GotoPart!=null) GotoPart.accept(visitor);
        if(Label!=null) Label.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GotoPart!=null) GotoPart.traverseTopDown(visitor);
        if(Label!=null) Label.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GotoPart!=null) GotoPart.traverseBottomUp(visitor);
        if(Label!=null) Label.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GoToStatement(\n");

        if(GotoPart!=null)
            buffer.append(GotoPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Label!=null)
            buffer.append(Label.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GoToStatement]");
        return buffer.toString();
    }
}
