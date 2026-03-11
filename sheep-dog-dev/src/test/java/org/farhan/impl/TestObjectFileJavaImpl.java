package org.farhan.impl;

import org.farhan.mbt.cucumber.CucumberInterface;
import org.junit.jupiter.api.Assertions;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.stmt.Statement;

public class TestObjectFileJavaImpl extends TestObjectFileImpl {

	private CucumberInterface wrapper;

	// --- get methods: return actual values, no assertions ---

	// Category 1: Value equality
	protected String getMethodAccessSpecifierValue(String methodName) {
		return getMethod(methodName).getAccessSpecifier().asString();
	}

	protected String getMethodReturnTypeValue(String methodName) {
		return getMethod(methodName).getTypeAsString();
	}

	protected String getMethodParameterTypeValue(String methodName, String parameterName) {
		return getMethod(methodName).getParameterByName(parameterName).get().getTypeAsString();
	}

	protected String getPackageValue() {
		CompilationUnit cu = (CompilationUnit) wrapper.get();
		return cu.getPackageDeclaration().get().getNameAsString();
	}

	protected String getClassNameValue() {
		return getObject().getNameAsString();
	}

	protected String getInterfaceNameValue() {
		return getObject().getNameAsString();
	}

	protected String getExtendsValue() {
		return getObject().getExtendedTypes().getFirst().get().getNameAsString();
	}

	protected String getConstructorStatementValue(String constructorName) {
		return getObject().getConstructors().getFirst().getBody().getStatement(0).toString();
	}

	// Category 2: Existence checks
	protected String getImportExistsValue(String importName) {
		ImportDeclaration id = getImport(importName);
		return id == null ? null : id.getNameAsString();
	}

	protected String getMethodExistsValue(String methodName) {
		MethodDeclaration m = getMethod(methodName);
		return m == null ? null : m.getName().asString();
	}

	protected String getMethodAnnotationExistsValue(String methodName, String annotation) {
		AnnotationExpr a = getAnnotation(methodName, annotation);
		return a == null ? null : a.toString();
	}

	protected String getMethodParameterExistsValue(String methodName, String parameterName) {
		return getMethod(methodName).getParameterByName(parameterName).isPresent() ? parameterName : null;
	}

	protected String getMethodStatementExistsValue(String methodName, String statement) {
		Statement s = getStatement(methodName, statement);
		return s == null ? null : s.toString();
	}

	protected String getConstructorExistsValue(String name) {
		return getObject().getConstructors().isEmpty() ? null : getObject().getConstructors().getFirst().getNameAsString();
	}

	protected String getClassAnnotationExistsValue(String annotation) {
		return getObject().getAnnotationByName(annotation).isPresent() ? annotation : null;
	}

	protected String getConstructorAnnotationExistsValue(String constructorName, String annotation) {
		if (getObject().getConstructors().isEmpty()) return null;
		return getObject().getConstructors().getFirst().getAnnotationByName(annotation).isPresent() ? annotation : null;
	}

	// Category 3: Parse + init
	protected String getFileExistsValue() {
		String exists = getObjectExists();
		try {
			wrapper = new CucumberInterface(properties.get("object").toString());
			wrapper.parse(sr.get("", properties.get("object").toString()));
		} catch (Exception e) {
			Assertions.fail(e);
		}
		return exists;
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
