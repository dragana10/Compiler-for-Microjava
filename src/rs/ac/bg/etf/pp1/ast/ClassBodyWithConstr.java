// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyWithConstr extends ClassBody {

    private ClassBodyWithConstructorPart ClassBodyWithConstructorPart;

    public ClassBodyWithConstr (ClassBodyWithConstructorPart ClassBodyWithConstructorPart) {
        this.ClassBodyWithConstructorPart=ClassBodyWithConstructorPart;
        if(ClassBodyWithConstructorPart!=null) ClassBodyWithConstructorPart.setParent(this);
    }

    public ClassBodyWithConstructorPart getClassBodyWithConstructorPart() {
        return ClassBodyWithConstructorPart;
    }

    public void setClassBodyWithConstructorPart(ClassBodyWithConstructorPart ClassBodyWithConstructorPart) {
        this.ClassBodyWithConstructorPart=ClassBodyWithConstructorPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassBodyWithConstructorPart!=null) ClassBodyWithConstructorPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassBodyWithConstructorPart!=null) ClassBodyWithConstructorPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassBodyWithConstructorPart!=null) ClassBodyWithConstructorPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBodyWithConstr(\n");

        if(ClassBodyWithConstructorPart!=null)
            buffer.append(ClassBodyWithConstructorPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBodyWithConstr]");
        return buffer.toString();
    }
}
