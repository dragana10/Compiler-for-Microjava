// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class DesignatorParamsIncInc extends DesignatorStatementParams {

    private Designator Designator;
    private IncIncPart IncIncPart;

    public DesignatorParamsIncInc (Designator Designator, IncIncPart IncIncPart) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.IncIncPart=IncIncPart;
        if(IncIncPart!=null) IncIncPart.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public IncIncPart getIncIncPart() {
        return IncIncPart;
    }

    public void setIncIncPart(IncIncPart IncIncPart) {
        this.IncIncPart=IncIncPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(IncIncPart!=null) IncIncPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(IncIncPart!=null) IncIncPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(IncIncPart!=null) IncIncPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorParamsIncInc(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IncIncPart!=null)
            buffer.append(IncIncPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorParamsIncInc]");
        return buffer.toString();
    }
}
