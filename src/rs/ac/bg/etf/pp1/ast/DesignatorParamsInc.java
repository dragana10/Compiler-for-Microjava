// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class DesignatorParamsInc extends DesignatorStatementParams {

    private Designator Designator;
    private IncPart IncPart;

    public DesignatorParamsInc (Designator Designator, IncPart IncPart) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.IncPart=IncPart;
        if(IncPart!=null) IncPart.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public IncPart getIncPart() {
        return IncPart;
    }

    public void setIncPart(IncPart IncPart) {
        this.IncPart=IncPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(IncPart!=null) IncPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(IncPart!=null) IncPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(IncPart!=null) IncPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorParamsInc(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IncPart!=null)
            buffer.append(IncPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorParamsInc]");
        return buffer.toString();
    }
}
