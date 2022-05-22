package com.digitalpersona.onetouch.ui.swing.sample.Enrollment;

import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.verification.*;
import java.awt.*;

public class Forma_verificacion extends Forma_Captura {

    private DPFPVerification verificator = DPFPGlobal.getVerificationFactory().createVerification();

    Forma_verificacion(Frame owner) {
        super(owner);
    }

    @Override
    protected void init() {
        super.init();
        this.setTitle("Inscripción de huellas dactilares");
        updateStatus(0);
    }

    @Override
    protected void process(DPFPSample sample) {
        super.process(sample);

        DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        if (features != null) {
            DPFPVerificationResult result = verificator.verify(features, ((Huella_main) getOwner()).getTemplate());
            updateStatus(result.getFalseAcceptRate());
            if (result.isVerified()) {
                makeReport("La huella digital fue VERIFICADA.");
            } else {
                makeReport("La huella dactilar NO FUE VERIFICADA.");
            }
        }
    }

     private void updateStatus(int FAR) {
        setStatus(String.format("False Accept Rate (FAR) = %1$s", FAR));
    }

}
