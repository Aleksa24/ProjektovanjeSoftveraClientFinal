/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrednosniValidator.impl;

import ui.components.iValue.product.MenadzerNewPanel;

/**
 *
 * @author Aleksa
 */
public class VrednosniValidatorIndenticneSifre implements vrednosniValidator.VrednosniValidator {

    MenadzerNewPanel menadzerNewPanel;

    public VrednosniValidatorIndenticneSifre(MenadzerNewPanel menadzerNewPanel) {
        this.menadzerNewPanel = menadzerNewPanel;
    }

    @Override
    public void validate() throws Exception {
        menadzerNewPanel.getPasswordPanel().getJlabError().setText("");
        menadzerNewPanel.getPasswordAgainPanel().getJlabError().setText("");
        String passwordFirst = (String) menadzerNewPanel.getPasswordPanel().getValue();
        String passwordSecond = (String) menadzerNewPanel.getPasswordAgainPanel().getValue();

        if (!passwordFirst.equals(passwordSecond)) {
            menadzerNewPanel.getPasswordPanel().getJlabError().setText("Sifre moraju da budu iste");
            menadzerNewPanel.getPasswordAgainPanel().getJlabError().setText("Sifre moraju da budu iste");
            throw new Exception("Sifre moraju da budu iste");
        }
    }

}
