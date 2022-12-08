// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyWithoutConstr extends ClassBody {

    private ClassBodyWithoutConstructorPart ClassBodyWithoutConstructorPart;

    public ClassBodyWithoutConstr (ClassBodyWithoutConstructorPart ClassBodyWithoutConstructorPart) {
        this.ClassBodyWithoutConstructorPart=ClassBodyWithoutConstructorPart;
        if(ClassBodyWithoutConstructorPart!=null) ClassBodyWithoutConstructorPart.setParent(this);
    }

    public ClassBodyWithoutConstructorPart getClassBodyWithoutConstructorPart() {
        return ClassBodyWithoutConstructorPart;
    }

    public void setClassBodyWithoutConstructorPart(ClassBodyWithoutConstructorPart ClassBodyWithoutConstructorPart) {
        this.ClassBodyWithoutConstructorPart=ClassBodyWithoutConstructorPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassBodyWithoutConstructorPart!=null) ClassBodyWithoutConstructorPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassBodyWithoutConstructorPart!=null) ClassBodyWithoutConstructorPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassBodyWithoutConstructorPart!=null) ClassBodyWithoutConstructorPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBodyWithoutConstr(\n");

        if(ClassBodyWithoutConstructorPart!=null)
            buffer.append(ClassBodyWithoutConstructorPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBodyWithoutConstr]");
        return buffer.toString();
    }
}
