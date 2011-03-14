/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import ru.perm.kefir.bbcode.BBProcessor;

/**
 *
 * @author pavel
 */
public class ShowRenderPage extends ShowPage {

    private BBProcessor processor;

    public void ShowRenderPage(String page_id) {
        this.processor = new BBProcessor();
        this.ShowPage(page_id);


    }

    @Override
    public String showTitlePage() {
        return this.processor.process(this.titlepage);

    }

    @Override
    public String showAnonsPage() {
        return this.processor.process(this.anonspage);
    }

    @Override
    public String showTextPage() {
        return this.processor.process(this.textpage);
    }
}


