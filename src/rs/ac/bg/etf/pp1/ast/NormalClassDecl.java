// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class NormalClassDecl extends ClassDecl {

    private String className;
    private MulVarDecls MulVarDecls;
    private ClassBody ClassBody;

    public NormalClassDecl (String className, MulVarDecls MulVarDecls, ClassBody ClassBody) {
        this.className=className;
        this.MulVarDecls=MulVarDecls;
        if(MulVarDecls!=null) MulVarDecls.setParent(this);
        this.ClassBody=ClassBody;
        if(ClassBody!=null) ClassBody.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public MulVarDecls getMulVarDecls() {
        return MulVarDecls;
    }

    public void setMulVarDecls(MulVarDecls MulVarDecls) {
        this.MulVarDecls=MulVarDecls;
    }

    public ClassBody getClassBody() {
        return ClassBody;
    }

    public void setClassBody(ClassBody ClassBody) {
        this.ClassBody=ClassBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulVarDecls!=null) MulVarDecls.accept(visitor);
        if(ClassBody!=null) ClassBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulVarDecls!=null) MulVarDecls.traverseTopDown(visitor);
        if(ClassBody!=null) ClassBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulVarDecls!=null) MulVarDecls.traverseBottomUp(visitor);
        if(ClassBody!=null) ClassBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NormalClassDecl(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(MulVarDecls!=null)
            buffer.append(MulVarDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassBody!=null)
            buffer.append(ClassBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NormalClassDecl]");
        return buffer.toString();
    }
}
