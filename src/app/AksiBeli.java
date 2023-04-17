package app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class AksiBeli extends Pembelian implements PenjualanInterface{
    
    private ViewJual fg;

        public AksiBeli(ViewJual vg) {
            this.fg = vg;
        }
        
        public void setData() {
            super.setKdBeli(fg.getInputKdBeli().getText());
            super.setPembeli(fg.getInputPembeli().getText());
            super.setJenisMartabak(fg.getInputMartabak().getSelectedItem().toString());
            super.setJmlBeli(Integer.parseInt(fg.getInputJumlah().getText()));
            
            fg.getsKdBeli().setText(super.getKdBeli());
            fg.getsPembeli().setText(super.getPembeli());
            fg.getsMartabak().setText(super.getJenisMartabak());
            fg.getsJumlah().setText(String.valueOf((int)getJmlBeli()));
            fg.getsTotBayar().setText(String.valueOf((int)hsltotBayar()));
        }
        
        public void hitung() {
            super.setBayar(Double.parseDouble(fg.getInputBayar().getText()));
            
            fg.getInputBayar().setText(String.valueOf(super.getBayar()));
            fg.getsKembalian().setText(String.valueOf((int)hslKembalian()));
        }
        
        public void nota() {
            
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
        }else if(getJenisMartabak().equals("Martabak Telur Biasa")) {
            return 15000;
        }else if(getJenisMartabak().equals("Martabak Telur Spesial")) {
            return 20000;
        }else if(getJenisMartabak().equals("Martabak Telur Istimewa")) {
            return 25000;
        }else if(getJenisMartabak().equals("Martabak Telur Super")) {
            return 30000;
        }
        return 0;
    }   

    @Override
    public double hsltotBayar() {
        return hargaTiapJenis() * getJmlBeli();
    }

    @Override
    public double hslKembalian() {
        return super.getBayar() - hsltotBayar();
    }
    
}
