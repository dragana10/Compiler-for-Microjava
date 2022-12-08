// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class DesignatorParamsDec extends DesignatorStatementParams {

    private Designator Designator;
    private DecPart DecPart;

    public DesignatorParamsDec (Designator Designator, DecPart DecPart) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DecPart=DecPart;
        if(DecPart!=null) DecPart.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DecPart getDecPart() {
        return DecPart;
    }

    public void setDecPart(DecPart DecPart) {
        this.DecPart=DecPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DecPart!=null) DecPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DecPart!=null) DecPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DecPart!=null) DecPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorParamsDec(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DecPart!=null)
            buffer.append(DecPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorParamsDec]");
        return buffer.toString();
    }
}
