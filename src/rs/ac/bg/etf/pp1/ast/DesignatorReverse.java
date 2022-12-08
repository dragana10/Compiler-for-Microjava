// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class DesignatorReverse extends DesignatorStatementParams {

    private Designator Designator;
    private NumConst NumConst;

    public DesignatorReverse (Designator Designator, NumConst NumConst) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.NumConst=NumConst;
        if(NumConst!=null) NumConst.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public NumConst getNumConst() {
        return NumConst;
    }

    public void setNumConst(NumConst NumConst) {
        this.NumConst=NumConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(NumConst!=null) NumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(NumConst!=null) NumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(NumConst!=null) NumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorReverse(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NumConst!=null)
            buffer.append(NumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorReverse]");
        return buffer.toString();
    }
}
