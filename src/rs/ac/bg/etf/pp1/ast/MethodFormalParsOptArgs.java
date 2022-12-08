// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class MethodFormalParsOptArgs extends MethodFormPars {

    private ListOfFormParams ListOfFormParams;
    private ListOfOptParams ListOfOptParams;

    public MethodFormalParsOptArgs (ListOfFormParams ListOfFormParams, ListOfOptParams ListOfOptParams) {
        this.ListOfFormParams=ListOfFormParams;
        if(ListOfFormParams!=null) ListOfFormParams.setParent(this);
        this.ListOfOptParams=ListOfOptParams;
        if(ListOfOptParams!=null) ListOfOptParams.setParent(this);
    }

    public ListOfFormParams getListOfFormParams() {
        return ListOfFormParams;
    }

    public void setListOfFormParams(ListOfFormParams ListOfFormParams) {
        this.ListOfFormParams=ListOfFormParams;
    }

    public ListOfOptParams getListOfOptParams() {
        return ListOfOptParams;
    }

    public void setListOfOptParams(ListOfOptParams ListOfOptParams) {
        this.ListOfOptParams=ListOfOptParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfFormParams!=null) ListOfFormParams.accept(visitor);
        if(ListOfOptParams!=null) ListOfOptParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfFormParams!=null) ListOfFormParams.traverseTopDown(visitor);
        if(ListOfOptParams!=null) ListOfOptParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfFormParams!=null) ListOfFormParams.traverseBottomUp(visitor);
        if(ListOfOptParams!=null) ListOfOptParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodFormalParsOptArgs(\n");

        if(ListOfFormParams!=null)
            buffer.append(ListOfFormParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfOptParams!=null)
            buffer.append(ListOfOptParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodFormalParsOptArgs]");
        return buffer.toString();
    }
}
