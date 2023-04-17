package app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class AksiRekap extends Pembelian implements PenjualanInterface{
    private ViewJual gf;

    public AksiRekap(ViewJual vg) {
        this.gf= vg;
    }
    
    public void setUpdate() {
        super.setKdBeli(gf.getPilihKdBeli().getText());
        super.setPembeli(gf.getPilihPembeli().getText());
        super.setJenisMartabak(gf.getPilihMartabak().getSelectedItem().toString());
        super.setJmlBeli(Integer.parseInt(gf.getPilihJumlah().getText()));
            
        gf.getPilihKdBeli().setText(super.getKdBeli());
        gf.getPilihPembeli().setText(super.getPembeli());
        gf.getPilihMartabak().setSelectedItem(super.getJenisMartabak());
        gf.getPilihJumlah().setText(String.valueOf((int)super.getJmlBeli()));
        gf.getPilihTotBayar().setText(String.valueOf((int)hsltotBayar()));
    }

    @Override
    public double hargaTiapJenis() {
        if(getJenisMartabak().equals("Martabak Coklat")) {
            return 15000;
        }else if(getJenisMartabak().equals("Martabak Keju")) {
            return 15000;
        }else if(getJenisMartabak().equals("Martabak Coklat Keju")) {
            return 20000;
        }else if(getJenisMartabak().equals("Martabak Coklat Pisang")) {
            return 25000;
        }else if(getJenisMartabak().equals("Martabak Telur")) {
            return 15000;
        }else if(getJenisMartabak().equals("Martabak Telur Spesial")) {
            return 20000;
        }else if(getJenisMartabak().equals("Martabak Telur Istimewa")) {
            return 25000;
        }else if(getJenisMartabak().equals("Martabak Telur Super")) {
            return 30000;
        }
        return 0;    }

    @Override
    public double hsltotBayar() {
        return hargaTiapJenis() * getJmlBeli();
    }

    @Override
    public double hslKembalian() {
        return getBayar() - hsltotBayar();
    }
}
