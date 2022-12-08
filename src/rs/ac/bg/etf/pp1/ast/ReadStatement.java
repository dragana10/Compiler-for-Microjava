// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ReadStatement extends MatchedStatement {

    private ReadPart ReadPart;
    private Designator Designator;

    public ReadStatement (ReadPart ReadPart, Designator Designator) {
        this.ReadPart=ReadPart;
        if(ReadPart!=null) ReadPart.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public ReadPart getReadPart() {
        return ReadPart;
    }

    public void setReadPart(ReadPart ReadPart) {
        this.ReadPart=ReadPart;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReadPart!=null) ReadPart.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReadPart!=null) ReadPart.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReadPart!=null) ReadPart.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReadStatement(\n");

        if(ReadPart!=null)
            buffer.append(ReadPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReadStatement]");
        return buffer.toString();
    }
}
