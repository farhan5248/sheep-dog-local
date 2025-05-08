package org.farhan.common;

import org.farhan.mbt.cucumber.CucumberInterface;
import org.junit.jupiter.api.Assertions;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.stmt.Statement;

public class JavaFileObject extends FileObject {

	private CucumberInterface wrapper;

	protected void assertImportExists(String importName) {
		Assertions.assertTrue(getImport(importName) != null, "Import " + importName + " doesn't exist");
	}

	protected void assertExtendsIs(String name) {
		Assertions.assertEquals(name, getObject().getExtendedTypes().getFirst().get().getNameAsString());
	}

	protected void assertConstructorExists(String name) {
		Assertions.assertEquals(name, getObject().getConstructors().getFirst().getNameAsString());
	}

	protected void assertClassNameIs(String name) {
		Assertions.assertEquals(name, getObject().getNameAsString());
	}

	protected void assertInterfaceNameIs(String name) {
		Assertions.assertEquals(name, getObject().getNameAsString());
	}

	protected void assertMethodAccessSpecifier(String methodName, String visibility) {
		assertMethodExists(methodName);
		Assertions.assertEquals(visibility, getMethod(methodName).getAccessSpecifier().asString());
	}

	protected void assertMethodAnnotationExists(String methodName, String annotation) {
		assertMethodExists(methodName);
		Assertions.assertTrue(getAnnotation(methodName, annotation) != null,
				"Annotation " + annotation + " doesn't exist");
	}

	protected void assertMethodExists(String methodName) {
		Assertions.assertTrue(getMethod(methodName) != null, "Method " + methodName + " doesn't exist");
	}

	protected void assertMethodParameterExists(String methodName, String parameterName) {
		assertMethodExists(methodName);
		Assertions.assertTrue(getMethod(methodName).getParameterByName(parameterName).get() != null,
				"Parameter Name " + parameterName + " doesn't exist");
	}

	protected void assertMethodParameterType(String methodName, String parameterName, String parameterType) {
		assertMethodExists(methodName);
		Assertions.assertEquals(parameterType,
				getMethod(methodName).getParameterByName(parameterName).get().getTypeAsString());
	}

	protected void assertMethodReturnType(String methodName, String returnType) {
		assertMethodExists(methodName);
		MethodDeclaration methodDeclaration = getMethod(methodName);
		Assertions.assertEquals(returnType, methodDeclaration.getTypeAsString());
	}

	protected void assertConstructorStatementExists(String constructorName, String statement) {
		assertConstructorExists(constructorName);
		Assertions.assertEquals(statement,
				getObject().getConstructors().getFirst().getBody().getStatement(0).toString(),
				"Statement " + statement + " doesn't exist");
	}

	protected void assertClassAnnotationExists(String annotation) {
		Assertions.assertTrue(getObject().getAnnotationByName(annotation).get() != null,
				"Class Annotation " + annotation + " doesn't exist");
	}

	protected void assertConstructorAnnotationExists(String constructorName, String annotation) {
		assertConstructorExists(constructorName);
		Assertions.assertTrue(getObject().getConstructors().getFirst().getAnnotationByName(annotation) != null,
				"Constructor Annotation " + annotation + " doesn't exist");
	}

	protected void assertMethodStatementExists(String methodName, String statement) {
		assertMethodExists(methodName);
		Assertions.assertTrue(getStatement(methodName, statement) != null, "Statement " + statement + " doesn't exist");
	}

	protected void assertFileExists() {
		super.assertFileExists();
		try {
			wrapper = new CucumberInterface(attributes.get("path"));
			wrapper.parse(sr.get(attributes.get("path")));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}

	protected void assertPackage(String packageName) {
		CompilationUnit cu = (CompilationUnit) wrapper.get();
		Assertions.assertEquals(packageName, cu.getPackageDeclaration().get().getNameAsString());
	}

	private AnnotationExpr getAnnotation(String methodName, String annotation) {
		for (AnnotationExpr a : getMethod(methodName).getAnnotations()) {
			if (a.toString().contentEquals(annotation)) {
				return a;
			}
		}
		return null;
	}

	private ImportDeclaration getImport(String importName) {
		CompilationUnit cu = (CompilationUnit) wrapper.get();
		for (ImportDeclaration id : cu.getImports()) {
			id.getNameAsString();
			if (id.getNameAsString().contentEquals(importName)) {
				return id;
			}
		}
		return null;
	}

	private MethodDeclaration getMethod(String methodName) {
		for (MethodDeclaration m : getObject().getMethods()) {
			if (m.getName().asString().contentEquals(methodName)) {
				return m;
			}
		}
		return null;
	}

	private ClassOrInterfaceDeclaration getObject() {
		CompilationUnit cu = (CompilationUnit) wrapper.get();
		return (ClassOrInterfaceDeclaration) cu.getType(0);
	}

	private Statement getStatement(String methodName, String statement) {

		for (Statement s : getMethod(methodName).getBody().get().getStatements()) {
			s.toString();
			if (s.toString().contentEquals(statement)) {
				return s;
			}
		}
		return null;
	}
}
