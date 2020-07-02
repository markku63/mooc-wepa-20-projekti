/*
 * The MIT License
 *
 * Copyright 2020 Markku Kolkka <markku.kolkka@iki.fi>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package projekti;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Markku Kolkka <markku.kolkka@iki.fi>
 */
@Controller
public class KayttajaController {
       
    @GetMapping("/login")
    public String login(Model model, @RequestParam Map<String, String> parametrit) {
        if (parametrit.containsKey("error")) {
            model.addAttribute("error", Boolean.TRUE);
        }
        if (parametrit.containsKey("logout")) {
            model.addAttribute("logout", Boolean.TRUE);
        }
        return "login";
    }

    @GetMapping("/rekisterointi")
    public String uusiKayttaja(Model model) {
        return "rekisterointi";
    }
    
    @PostMapping("/rekisterointi")
    public String lisaaKayttaja(Model model) {
        return "redirect:/";
    }
}