package org.farhan.mbt.core;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class UMLElement {

	protected String id;
	protected UMLElement parent;

	protected Class addClass(String qualifiedName, Model theModel) {
		Class theClass = null;
		Package owningPackage = theModel;
		String[] qualifiedNameParts = qualifiedName.replace(theModel.getQualifiedName() + "::", "").split("::");
		for (int i = 0; i < qualifiedNameParts.length; i++) {
			if (i == qualifiedNameParts.length - 1) {
				theClass = owningPackage.createOwnedClass(qualifiedNameParts[i], false);
			} else {
				owningPackage = addPackage(owningPackage, qualifiedNameParts[i]);
			}
		}
		return theClass;
	}

	protected Interaction addInteraction(Class theClass, String interactionName, String annotationName) {
		Interaction anInteraction = (Interaction) theClass.getOwnedBehavior(interactionName);
		if (anInteraction == null) {
			anInteraction = UMLFactory.eINSTANCE.createInteraction();
			anInteraction.setName(interactionName);
			theClass.setClassifierBehavior(anInteraction);
		}
		if (!annotationName.isEmpty()) {
			createAnnotation(anInteraction, annotationName);
		}
		return anInteraction;
	}

	protected Package addPackage(Package nestingPackage, String name) {
		Package thePackage = nestingPackage.getNestedPackage(name);
		if (thePackage == null) {
			thePackage = nestingPackage.createNestedPackage(name);
		}
		return thePackage;
	}

	protected EAnnotation createAnnotation(BehavioredClassifier anInteraction, String name) {
		EAnnotation a = anInteraction.getEAnnotation(name);
		if (a == null) {
			a = anInteraction.createEAnnotation(name);
		}
		return a;
	}

	protected EAnnotation createAnnotation(BehavioredClassifier className, String name, String key) {
		EAnnotation a = className.getEAnnotation(name);
		if (a == null) {
			a = className.createEAnnotation(name);
		}
		if (!key.isEmpty()) {
			a.getDetails().put(key, "");
		}
		return a;
	}

	protected EAnnotation createAnnotation(BehavioredClassifier anInteraction, String name, String key, String value) {
		EAnnotation a = createAnnotation(anInteraction, name);
		a.getDetails().put(key, value);
		return a;
	}

	protected EAnnotation createAnnotation(Message aMessage, String name, String key, String value) {
		EAnnotation a = aMessage.getEAnnotation(name);
		if (a == null) {
			a = aMessage.createEAnnotation(name);
		}
		a.getDetails().put(key, value);
		return a;
	}

	protected EAnnotation createAnnotation(ValueSpecification vs, String name, String key, String value) {
		EAnnotation a = vs.getEAnnotation(name);
		if (a == null) {
			a = vs.createEAnnotation(name);
		}
		a.getDetails().put(key, value);
		return a;
	}

	public String getId() {
		return id;
	}

	public UMLElement getParent() {
		return parent;
	}

	public void setId(String id) {
		this.id = id;
	}

}
