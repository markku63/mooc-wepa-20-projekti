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
package projekti.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Markku Kolkka <markku.kolkka@iki.fi>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kayttaja extends AbstractPersistable<Long> {

    @ManyToMany(mappedBy = "kehujat")
    private List<Taito> kehututTaidot;
    @ManyToMany(mappedBy = "tykkaajat")
    private List<Viesti> tykatytViestit;
    @Column(nullable=false)
    private String nimi;
    @Column(nullable=false)
    private String salasana;
    @Column(unique=true, nullable=false)
    private String tunnus;
    @Column(unique=true, nullable=false)
    private String profiilijono;
    @OneToOne
    private Kuva kuva;
}
