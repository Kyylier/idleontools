/**
 * This package contains tooling to pull data from the main application binary (Z.js).
 * <p>
 *     The general idea is to parse the binary, extract the bootstrapping function, run this in a JavaScript VM (Rhino),
 *     then interact with the partially initialized game to extract useful data. This *should* be faster than manually
 *     trawling through the code for the data you want, especially as updates happen.
 * </p>
 * <p>
 *     Blue Sky Ideas:
 *     <ul>
 *         <li>Code-gen classes like those found in {@link scratch.idleontools.gamedata}, which are a pain to compile.</li>
 *         <li>Optimizers that use the real game functions instead of reverse-engineered functions.</li>
 *         <li>Live integration with game save data for checklists, trackers, etc.</li>
 *     </ul>
 * </p>
 */
package scratch.idleontools.jsbridge;