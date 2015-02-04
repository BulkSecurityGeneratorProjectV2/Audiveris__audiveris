//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                             F e r m a t a C h o r d R e l a t i o n                            //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package omr.sig.relation;

import omr.constant.Constant;
import omr.constant.ConstantSet;

/**
 * Class {@code FermataChordRelation} represents the relation between a fermata and
 * a chord.
 *
 * @author Hervé Bitteur
 */
public class FermataChordRelation
        extends BasicSupport
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Constants constants = new Constants();

    //~ Methods ------------------------------------------------------------------------------------
    @Override
    public String getName ()
    {
        return "Fermata-Chord";
    }

    @Override
    protected double getSourceCoeff ()
    {
        return constants.fermataSupportCoeff.getValue();
    }

    @Override
    protected double getTargetCoeff ()
    {
        return constants.chordSupportCoeff.getValue();
    }

    //~ Inner Classes ------------------------------------------------------------------------------
    //-----------//
    // Constants //
    //-----------//
    private static final class Constants
            extends ConstantSet
    {
        //~ Instance fields ------------------------------------------------------------------------

        final Constant.Ratio fermataSupportCoeff = new Constant.Ratio(
                5,
                "Supporting coeff for fermata");

        final Constant.Ratio chordSupportCoeff = new Constant.Ratio(
                2,
                "Supporting coeff for chord");
    }
}
