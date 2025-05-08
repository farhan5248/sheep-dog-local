package org.farhan.common;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ValueSpecification;
import org.farhan.mbt.core.UMLTestProject;
import org.junit.jupiter.api.Assertions;

public abstract class UMLFileObject extends FileObject {

	private UMLTestProject project;

	protected void assertClassAnnotationDetailExists(String className, String annotationName, String annotationDetail) {
		assertClassExists(className);
		EAnnotation annotation = getAnnotation(getObject(className), annotationName);
		Assertions.assertTrue(getAnnotationDetail(annotation, annotationDetail) != null, "Class " + className
				+ " Annotation " + annotationName + " Annotation Detail " + annotationDetail + " doesn't exist");
	}

	protected void assertClassAnnotationNameExists(String className, String annotationName) {
		assertClassExists(className);
		Assertions.assertTrue(getAnnotation(getObject(className), annotationName) != null,
				"Class " + className + " Annotation " + annotationName + " doesn't exist");
	}

	protected void assertClassCommentValue(String className, String commentBody) {
		assertClassExists(className);
		Assertions.assertEquals(commentBody, getObject(className).getOwnedComments().get(0).getBody());
	}

	protected void assertClassExists(String className) {
		Assertions.assertTrue(getObject(className) != null, "Class " + className + " doesn't exist");
	}

	protected void assertClassNotExists(String className) {
		Assertions.assertFalse(getObject(className) != null, "Class " + className + " does exist");
	}

	protected void assertClassInteractionExists(String className, String interactionName) {
		assertClassExists(className);
		Assertions.assertTrue(getObject(className).getOwnedBehavior(interactionName) != null,
				"Class " + className + " Interaction " + interactionName + " doesn't exist");
	}

	protected void assertInteractionAnnotationDetailExists(String interactionName, String annotationName,
			String annotationDetail) {
		assertInteractionExists(interactionName);
		EAnnotation annotation = getAnnotation(getInteraction(interactionName), annotationName);
		Assertions.assertTrue(getAnnotationDetail(annotation, annotationDetail) != null,
				"Interaction " + interactionName + " Annotation " + annotationName + " Annotation Detail "
						+ annotationDetail + " doesn't exist");
	}

	protected void assertInteractionAnnotationNameExists(String interactionName, String annotationName) {
		assertInteractionExists(interactionName);
		EAnnotation annotation = getAnnotation(getInteraction(interactionName), annotationName);
		Assertions.assertTrue(annotation != null,
				"Interaction " + interactionName + " Annotation " + annotationName + " doesn't exist");
	}

	protected void assertInteractionCommentValue(String interactionName, String commentBody) {
		assertInteractionExists(interactionName);
		Assertions.assertEquals(commentBody, getInteraction(interactionName).getOwnedComments().getFirst().getBody());

	}

	protected void assertInteractionExists(String interactionName) {
		Assertions.assertTrue(getInteraction(interactionName) != null,
				"Interaction " + interactionName + " doesn't exist");
	}

	protected void assertInteractionNotExists(String interactionName) {
		Assertions.assertFalse(getInteraction(interactionName) != null,
				"Interaction " + interactionName + " does exist");
	}

	protected void assertInteractionMessageAnnotationDetailExists(String interactionName, String messageName,
			String argumentName, String annotationDetail) {
		assertInteractionExists(interactionName);
		Message message = getMessage(getInteraction(interactionName), messageName);
		ValueSpecification vs = (LiteralString) message.getArgument(argumentName, null);

		EAnnotation annotation = null;
		for (EAnnotation e : vs.getEAnnotations()) {
			if (e.getSource().contentEquals(argumentName)) {
				annotation = e;
				break;
			}
		}
		Entry<String, String> detail = null;
		for (Entry<String, String> d : annotation.getDetails()) {
			String e = d.getKey() + " -> " + d.getValue();
			if (e.contentEquals(annotationDetail)) {
				detail = d;
				break;
			}
		}
		Assertions.assertTrue(detail != null, "Interaction " + interactionName + " Message " + messageName
				+ " Argument Name " + argumentName + " Annotation Detail " + annotationDetail + " doesn't exist");

	}

	protected void assertInteractionMessageArgumentNameExists(String interactionName, String messageName,
			String argumentName) {
		assertInteractionExists(interactionName);
		Message message = getMessage(getInteraction(interactionName), messageName);
		ValueSpecification vs = (LiteralString) message.getArgument(argumentName, null);
		Assertions.assertTrue(vs != null, "Interaction " + interactionName + " Message " + messageName
				+ " Argument Name " + argumentName + " doesn't exist");

	}

	protected void assertInteractionMessageValue(String interactionName, String messageName) {
		assertInteractionExists(interactionName);
		Assertions.assertTrue(getMessage(getInteraction(interactionName), messageName) != null,
				"Interaction " + interactionName + " Message " + messageName + " doesn't exist");

	}

	protected void assertFileExists() {
		try {
			project = new UMLTestProject(getGoalClass("ToUml").attributes.get("tags"), new FileObjectRepository());
			project.init();
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}

	private EAnnotation getAnnotation(Class theClass, String annotationName) {
		for (EAnnotation e : theClass.getEAnnotations()) {
			if (e.getSource().contentEquals(annotationName)) {
				return e;
			}
		}
		return null;
	}

	private EAnnotation getAnnotation(Interaction interaction, String annotationName) {
		for (EAnnotation e : interaction.getEAnnotations()) {
			if (e.getSource().contentEquals(annotationName)) {
				return e;
			}
		}
		return null;
	}

	private Entry<String, String> getAnnotationDetail(EAnnotation annotation, String annotationDetail) {
		if (annotation.getDetails() == null) {
			return null;
		}
		for (Entry<String, String> d : annotation.getDetails()) {
			if (annotationDetail.contains(" -> ")) {
				if (annotationDetail.contentEquals(d.getKey() + " -> " + d.getValue())) {
					return d;
				}
			} else {
				if (annotationDetail.contentEquals(d.getKey())) {
					return d;
				}
			}
		}
		return null;
	}

	private Interaction getInteraction(String interactionName) {
		return (Interaction) project.getPackagedElement("pst" + "::" + interactionName, null);
	}

	private Message getMessage(Interaction interaction, String name) {
		for (NamedElement ne : interaction.getOwnedMembers()) {
			if (ne.getName().contentEquals(name)) {
				return (Message) ne;
			}
		}
		return null;
	}

	private Class getObject(String className) {
		return (Class) project.getPackagedElement("pst" + "::" + className, null);
	}

}
