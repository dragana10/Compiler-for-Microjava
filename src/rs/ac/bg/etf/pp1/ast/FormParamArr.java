// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class FormParamArr extends FormParam {

    private Type Type;
    private FormParamName FormParamName;

    public FormParamArr (Type Type, FormParamName FormParamName) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormParamName=FormParamName;
        if(FormParamName!=null) FormParamName.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FormParamName getFormParamName() {
        return FormParamName;
    }

    public void setFormParamName(FormParamName FormParamName) {
        this.FormParamName=FormParamName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FormParamName!=null) FormParamName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParamName!=null) FormParamName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParamName!=null) FormParamName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParamArr(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParamName!=null)
            buffer.append(FormParamName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParamArr]");
        return buffer.toString();
    }
}
