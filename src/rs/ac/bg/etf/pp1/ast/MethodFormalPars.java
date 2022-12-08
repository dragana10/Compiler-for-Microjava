// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class MethodFormalPars extends MethodFormPars {

    private ListOfFormParams ListOfFormParams;
    private FormParam FormParam;

    public MethodFormalPars (ListOfFormParams ListOfFormParams, FormParam FormParam) {
        this.ListOfFormParams=ListOfFormParams;
        if(ListOfFormParams!=null) ListOfFormParams.setParent(this);
        this.FormParam=FormParam;
        if(FormParam!=null) FormParam.setParent(this);
    }

    public ListOfFormParams getListOfFormParams() {
        return ListOfFormParams;
    }

    public void setListOfFormParams(ListOfFormParams ListOfFormParams) {
        this.ListOfFormParams=ListOfFormParams;
    }

    public FormParam getFormParam() {
        return FormParam;
    }

    public void setFormParam(FormParam FormParam) {
        this.FormParam=FormParam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfFormParams!=null) ListOfFormParams.accept(visitor);
        if(FormParam!=null) FormParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfFormParams!=null) ListOfFormParams.traverseTopDown(visitor);
        if(FormParam!=null) FormParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfFormParams!=null) ListOfFormParams.traverseBottomUp(visitor);
        if(FormParam!=null) FormParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodFormalPars(\n");

        if(ListOfFormParams!=null)
            buffer.append(ListOfFormParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParam!=null)
            buffer.append(FormParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodFormalPars]");
        return buffer.toString();
    }
}
