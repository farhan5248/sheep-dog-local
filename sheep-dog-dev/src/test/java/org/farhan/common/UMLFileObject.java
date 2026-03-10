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

public abstract class UMLFileObject extends TestObjectFile {

	private UMLTestProject project;

	// --- get methods: return actual values, no assertions ---

	// Category 1: Value equality
	protected String getClassCommentValueValue(String className) {
		return getObject(className).getOwnedComments().get(0).getBody();
	}

	protected String getInteractionCommentValueValue(String interactionName) {
		return getInteraction(interactionName).getOwnedComments().getFirst().getBody();
	}

	// Category 2: Existence checks
	protected String getClassExistsValue(String className) {
		Class c = getObject(className);
		return c == null ? null : className;
	}

	protected String getClassNotExistsValue(String className) {
		Class c = getObject(className);
		return c != null ? null : className;
	}

	protected String getClassAnnotationNameExistsValue(String className, String annotationName) {
		EAnnotation a = getAnnotation(getObject(className), annotationName);
		return a == null ? null : annotationName;
	}

	protected String getClassAnnotationDetailExistsValue(String className, String annotationName, String annotationDetail) {
		EAnnotation annotation = getAnnotation(getObject(className), annotationName);
		Entry<String, String> detail = getAnnotationDetail(annotation, annotationDetail);
		return detail == null ? null : annotationDetail;
	}

	protected String getClassInteractionExistsValue(String className, String interactionName) {
		Object behavior = getObject(className).getOwnedBehavior(interactionName);
		return behavior == null ? null : interactionName;
	}

	protected String getInteractionExistsValue(String interactionName) {
		Interaction i = getInteraction(interactionName);
		return i == null ? null : interactionName;
	}

	protected String getInteractionNotExistsValue(String interactionName) {
		Interaction i = getInteraction(interactionName);
		return i != null ? null : interactionName;
	}

	protected String getInteractionAnnotationNameExistsValue(String interactionName, String annotationName) {
		EAnnotation a = getAnnotation(getInteraction(interactionName), annotationName);
		return a == null ? null : annotationName;
	}

	protected String getInteractionAnnotationDetailExistsValue(String interactionName, String annotationName, String annotationDetail) {
		EAnnotation annotation = getAnnotation(getInteraction(interactionName), annotationName);
		Entry<String, String> detail = getAnnotationDetail(annotation, annotationDetail);
		return detail == null ? null : annotationDetail;
	}

	protected String getInteractionMessageValueValue(String interactionName, String messageName) {
		Message m = getMessage(getInteraction(interactionName), messageName);
		return m == null ? null : messageName;
	}

	protected String getInteractionMessageArgumentNameExistsValue(String interactionName, String messageName, String argumentName) {
		Message message = getMessage(getInteraction(interactionName), messageName);
		ValueSpecification vs = (LiteralString) message.getArgument(argumentName, null);
		return vs == null ? null : argumentName;
	}

	protected String getInteractionMessageAnnotationDetailExistsValue(String interactionName, String messageName, String argumentName, String annotationDetail) {
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
		return detail == null ? null : annotationDetail;
	}

	// Category 3: Parse + init
	protected String getFileExistsValue() {
		try {
			project = new UMLTestProject(getTestObjectClass("ToUml", "org.farhan.objects.maven.").properties.get("tags").toString(), new ServiceFileRepository());
			project.init();
		} catch (Exception e) {
			Assertions.fail(e);
		}
		return "true";
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
