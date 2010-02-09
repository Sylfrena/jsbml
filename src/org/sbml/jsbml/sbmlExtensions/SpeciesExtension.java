package org.sbml.jsbml.sbmlExtensions;

import org.sbml.jsbml.Annotation;
import org.sbml.jsbml.Compartment;
import org.sbml.jsbml.Model;
import org.sbml.jsbml.Parameter;
import org.sbml.jsbml.SBMLDocument;
import org.sbml.jsbml.SBaseChangedListener;
import org.sbml.jsbml.Species;
import org.sbml.jsbml.SpeciesType;
import org.sbml.jsbml.Unit;
import org.sbml.jsbml.UnitDefinition;
import org.sbml.jsbml.Unit.Kind;

/**
 * 
 * @author Andreas Dr&auml;ger
 * 
 * @opt attributes
 * @opt types
 * @opt visibility
 *
 */
public class SpeciesExtension extends Species{

	private Species species;
	
	public SpeciesExtension(Species species){
		this.species = species;
	}
	
	public org.sbml.jsbml.Species clone(){
		return species.clone();
	}

	public boolean getBoundaryCondition() {
		return species.getBoundaryCondition();
	}

	@SuppressWarnings("deprecation")
	public int getCharge() {
		return species.getCharge();
	}

	public String getCompartment() {
		return species.getCompartment();
	}

	public Compartment getCompartmentInstance() {
		return species.getCompartmentInstance();
	}

	public Parameter getConversionFactorInstance() {
		return species.getConversionFactorInstance();
	}

	public String getConversionFactor() {
		return species.getConversionFactor();
	}

	public boolean getHasOnlySubstanceUnits() {
		return species.getHasOnlySubstanceUnits();
	}

	public double getInitialAmount() {
		return species.getInitialAmount();
	}

	public double getInitialConcentration() {
		return species.getInitialConcentration();
	}

	public Model getParentSBMLObject() {
		return species.getParentSBMLObject();
	}

	@SuppressWarnings("deprecation")
	public String getSpeciesType() {
		return species.getSpeciesType();
	}

	@SuppressWarnings("deprecation")
	public SpeciesType getSpeciesTypeInstance() {
		return species.getSpeciesTypeInstance();
	}

	public String getSubstanceUnits() {
		return species.getSubstanceUnits();
	}

	public UnitDefinition getSubstanceUnitsInstance() {
		return species.getSubstanceUnitsInstance();
	}

	public void initDefaults() {
		species.initDefaults();
	}

	public boolean isBoundaryCondition() {
		return species.getBoundaryCondition();
	}

	public boolean isHasOnlySubstanceUnits() {
		return species.isHasOnlySubstanceUnits();
	}

	public boolean isSetCharge() {
		return species.isSetCharge();
	}

	public boolean isSetCompartmentInstance() {
		return species.isSetCompartmentInstance();
	}

	public boolean isSetCompartment() {
		return species.isSetCompartment();
	}

	public boolean isSetConversionFactor() {
		return species.isSetConversionFactor();
	}

	public boolean isSetConversionFactorInstance() {
		return species.isSetConversionFactorInstance();
	}

	public boolean isSetInitialAmount() {
		return species.isSetInitialAmount();
	}

	public boolean isSetInitialConcentration() {
		return species.isSetInitialConcentration();
	}

	public boolean isSetSpeciesType() {
		return species.isSetSpeciesType();
	}

	@SuppressWarnings("deprecation")
	public boolean isSetSpeciesTypeInstance() {
		return species.isSetSpeciesTypeInstance();
	}

	public boolean isSetSubstanceUnitsInstance() {
		return species.isSetSubstanceUnitsInstance();
	}

	public boolean isSetSubstanceUnits() {
		return species.isSetSubstanceUnits();
	}

	public boolean readAttribute(String attributeName, String prefix,
			String value) {
		return species.readAttribute(attributeName, prefix, value);
	}

	public void setBoundaryCondition(boolean boundaryCondition) {
		species.setBoundaryCondition(boundaryCondition);
	}

	public void setCharge(int charge) {
		species.setCharge(charge);
	}

	public void setCompartment(Compartment compartment) {
		species.setCompartment(compartment);
	}

	public void setCompartment(String compartment) {
		species.setCompartment(compartment);
	}

	public void setConversionFactor(Parameter conversionFactor) {
		species.setConversionFactor(conversionFactor);
	}

	public void setConversionFactor(String conversionFactorID) {
		species.setConversionFactor(conversionFactorID);
	}

	public void setHasOnlySubstanceUnits(boolean hasOnlySubstanceUnits) {
		species.setHasOnlySubstanceUnits(hasOnlySubstanceUnits);
	}

	public void setInitialAmount(double initialAmount) {
		species.setInitialAmount(initialAmount);
	}

	public void setInitialConcentration(double initialConcentration) {
		species.setInitialConcentration(initialConcentration);
	}

	@SuppressWarnings("deprecation")
	public void setSpeciesType(SpeciesType speciesType) {
		species.setSpeciesType(speciesType);
	}

	public void setSpeciesType(String speciesType) {
		species.setSpeciesType(speciesType);
	}

	public void setSubstanceUnits(Unit unit) {
		species.setSubstanceUnits(unit);
	}

	public void setSubstanceUnits(Kind unitKind) {
		species.setSubstanceUnits(unitKind);
	}

	public void setSubstanceUnits(UnitDefinition units) {
		species.setSubstanceUnits(units);
	}

	public void addChangeListener(SBaseChangedListener l) {
		species.addChangeListener(l);
	}

	public void appendNotes(String notes) {
		species.appendNotes(notes);
	}

	public Annotation getAnnotation() {
		return species.getAnnotation();
	}

	public String getElementName() {
		return species.getElementName();
	}

	public int getLevel() {
		return species.getLevel();
	}

	public String getMetaId() {
		return species.getMetaId();
	}

	public Model getModel() {
		return species.getModel();
	}

	public StringBuffer getNotesBuffer() {
		return species.getNotesBuffer();
	}

	public String getNotesString() {
		return species.getNotesString();
	}

	public SBMLDocument getSBMLDocument() {
		return species.getSBMLDocument();
	}

	public int getSBOTerm() {
		return species.getSBOTerm();
	}

	public String getSBOTermID() {
		return species.getSBOTermID();
	}

	public int getVersion() {
		return species.getVersion();
	}

	public boolean hasValidAnnotation() {
		return species.hasValidAnnotation();
	}

	public boolean hasValidLevelVersionNamespaceCombination() {
		return species.hasValidLevelVersionNamespaceCombination();
	}

	public boolean isSetAnnotation() {
		return species.isSetAnnotation();
	}

	public boolean isSetMetaId() {
		return species.isSetMetaId();
	}

	public boolean isSetNotes() {
		return species.isSetNotes();
	}

	public boolean isSetSBOTerm() {
		return species.isSetSBOTerm();
	}

	public void sbaseAdded() {
		species.sbaseAdded();
	}

	public void sbaseRemoved() {
		species.sbaseRemoved();
	}

	public void setAnnotation(Annotation annotation) {
		species.setAnnotation(annotation);
	}

	public void setMetaId(String metaid) {
		species.setMetaId(metaid);
	}

	public void setNotes(String notes) {
		species.setNotes(notes);
	}

	public void setNotesBuffer(StringBuffer notes) {
		species.setNotesBuffer(notes);
	}

	public void setSBOTerm(int term) {
		species.setSBOTerm(term);
	}

	public void setSBOTerm(String sboid) {
		species.setSBOTerm(sboid);
	}

	public void stateChanged() {
		species.stateChanged();
	}

	public void unsetAnnotation() {
		species.unsetAnnotation();
	}

	public void unsetMetaId() {
		species.unsetMetaId();
	}

	public void unsetNotes() {
		species.unsetNotes();
	}

	public void unsetSBOTerm() {
		species.unsetSBOTerm();
	}
}
