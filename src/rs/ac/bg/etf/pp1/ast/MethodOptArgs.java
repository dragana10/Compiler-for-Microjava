// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class MethodOptArgs extends MethodFormPars {

    private OptArg OptArg;
    private ListOfOptParams ListOfOptParams;

    public MethodOptArgs (OptArg OptArg, ListOfOptParams ListOfOptParams) {
        this.OptArg=OptArg;
        if(OptArg!=null) OptArg.setParent(this);
        this.ListOfOptParams=ListOfOptParams;
        if(ListOfOptParams!=null) ListOfOptParams.setParent(this);
    }

    public OptArg getOptArg() {
        return OptArg;
    }

    public void setOptArg(OptArg OptArg) {
        this.OptArg=OptArg;
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
        if(OptArg!=null) OptArg.accept(visitor);
        if(ListOfOptParams!=null) ListOfOptParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptArg!=null) OptArg.traverseTopDown(visitor);
        if(ListOfOptParams!=null) ListOfOptParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptArg!=null) OptArg.traverseBottomUp(visitor);
        if(ListOfOptParams!=null) ListOfOptParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodOptArgs(\n");

        if(OptArg!=null)
            buffer.append(OptArg.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfOptParams!=null)
            buffer.append(ListOfOptParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodOptArgs]");
        return buffer.toString();
    }
}
