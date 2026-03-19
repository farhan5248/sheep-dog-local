package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestSuite;

public class TestProjectImpl implements ITestProject {

	ArrayList<ITestDocument> testDocumentList;

	TestProjectImpl() {
		this.testDocumentList = new ArrayList<ITestDocument>();
	}

	@Override
	public String getFileExtension() {
		return ".asciidoc";
	}

	@Override
	public ITestDocument getTestDocument(String fullName) {
		for (ITestDocument td : this.testDocumentList) {
			if (td.getFullName().contentEquals(fullName)) {
				return td;
			}
		}
		return null;
	}

	@Override
	public List<ITestDocument> getTestDocumentList() {
		return Collections.unmodifiableList(testDocumentList);
	}

	@Override
	public ITestDocument getTestDocument(int index) {
		return testDocumentList.get(index);
	}

	@Override
	public boolean addTestSuite(ITestSuite value) {
		return addToSortedList(value, (TestSuiteImpl) value);
	}

	@Override
	public boolean addStepObject(IStepObject value) {
		return addToSortedList(value, (StepObjectImpl) value);
	}

	private boolean addToSortedList(ITestDocument value, Object implValue) {
		for (int i = 0; i < testDocumentList.size(); i++) {
			if (testDocumentList.get(i).getFullName().contentEquals(value.getFullName())) {
				testDocumentList.set(i, value);
				setParent(implValue);
				return true;
			}
		}
		int insertIndex = Collections.binarySearch(
				testDocumentList.stream().map(ITestDocument::getFullName).toList(),
				value.getFullName());
		if (insertIndex < 0) {
			insertIndex = -(insertIndex + 1);
		}
		testDocumentList.add(insertIndex, value);
		setParent(implValue);
		return true;
	}

	private void setParent(Object implValue) {
		if (implValue instanceof TestSuiteImpl ts) {
			ts.parent = this;
		} else if (implValue instanceof StepObjectImpl so) {
			so.parent = this;
		}
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("getName() is not implemented");
	}

	@Override
	public void setName(String name) {
		throw new UnsupportedOperationException("setName(String name) is not implemented");
	}

	@Override
	public String toString() {
		int count = testDocumentList != null ? testDocumentList.size() : 0;
		return "TestProject[" + count + " documents]";
	}

}
