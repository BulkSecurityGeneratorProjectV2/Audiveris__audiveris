//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                            C o d a                                             //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Hervé Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package omr.score.entity;

import omr.glyph.facets.Glyph;

import omr.score.visitor.ScoreVisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Point;

/**
 * Class {@code Coda} represents a coda event
 *
 * @author Hervé Bitteur
 */
public class Coda
        extends AbstractDirection
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(Coda.class);

    //~ Constructors -------------------------------------------------------------------------------
    //-------//
    // Coda //
    //-------//
    /**
     * Creates a new instance of Coda event
     *
     * @param measure measure that contains this mark
     * @param point   location of mark
     * @param chord   the chord related to the mark, if any
     * @param glyph   the underlying glyph
     */
    public Coda (OldMeasure measure,
                 Point point,
                 OldChord chord,
                 Glyph glyph)
    {
        super(measure, point, chord, glyph);
    }

    //~ Methods ------------------------------------------------------------------------------------
    //--------//
    // accept //
    //--------//
    @Override
    public boolean accept (ScoreVisitor visitor)
    {
        return visitor.visit(this);
    }

    //----------//
    // populate //
    //----------//
    /**
     * Used by SystemTranslator to allocate the coda marks
     *
     * @param glyph   underlying glyph
     * @param measure measure where the mark is located
     * @param point   location for the mark
     */
    public static void populate (Glyph glyph,
                                 OldMeasure measure,
                                 Point point)
    {
        if (glyph.isVip()) {
            logger.info("Coda. populate {}", glyph.idString());
        }

        OldSlot slot = measure.getClosestSlot(point);
        glyph.setTranslation(new Coda(measure, point, slot.getChordJustBelow(point), glyph));
    }
}
