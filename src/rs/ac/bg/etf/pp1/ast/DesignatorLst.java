// generated with ast extension for cup
// version 0.8
// 7/1/2022 3:1:25


package rs.ac.bg.etf.pp1.ast;

public class DesignatorLst extends DesignatorList {

    private DesignatorList DesignatorList;
    private DesignElem DesignElem;

    public DesignatorLst (DesignatorList DesignatorList, DesignElem DesignElem) {
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
        this.DesignElem=DesignElem;
        if(DesignElem!=null) DesignElem.setParent(this);
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public DesignElem getDesignElem() {
        return DesignElem;
    }

    public void setDesignElem(DesignElem DesignElem) {
        this.DesignElem=DesignElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.accept(visitor);
        if(DesignElem!=null) DesignElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
        if(DesignElem!=null) DesignElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        if(DesignElem!=null) DesignElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorLst(\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignElem!=null)
            buffer.append(DesignElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorLst]");
        return buffer.toString();
    }
}
