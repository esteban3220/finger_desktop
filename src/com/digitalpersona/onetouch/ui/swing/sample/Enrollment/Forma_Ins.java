package com.digitalpersona.onetouch.ui.swing.sample.Enrollment;

import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.processing.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class Forma_Ins extends Forma_Captura {

    private DPFPEnrollment enroller = DPFPGlobal.getEnrollmentFactory().createEnrollment();

    Forma_Ins(Frame owner) {
        super(owner);
    }

    @Override
    protected void init() {
        super.init();
        this.setTitle("Registro de huellas dactilarest");
        updateStatus();
    }

    @Override
    protected void process(DPFPSample sample) {
        super.process(sample);
        
        DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        if (features != null) {
            try {
                makeReport("Se creó el conjunto de funciones de huellas dactilares.");
                enroller.addFeatures(features);
            } catch (DPFPImageQualityException ex) {
            } finally {
                updateStatus();

                switch (enroller.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY:	
                        stop();
                        ((Huella_main) getOwner()).setTemplate(enroller.getTemplate());
                        setPrompt("Haga clic en Cerrar y luego haga clic en Verificación de huellas dactilares.");
                        break;

                    case TEMPLATE_STATUS_FAILED:	
                        enroller.clear();
                        stop();
                        updateStatus();
                        ((Huella_main) getOwner()).setTemplate(null);
                        JOptionPane.showMessageDialog(Forma_Ins.this, "La plantilla de huella digital no es válida. Repita el registro de huellas dactilares.", "Registro de huellas dactilares", JOptionPane.ERROR_MESSAGE);
                        start();
                        break;
                }
            }
        }
    }

    private void updateStatus() {
        // Show number of samples needed.
        setStatus(String.format("Se necesitan muestras de huellas dactilares: %1$s", enroller.getFeaturesNeeded()));
    }

}
