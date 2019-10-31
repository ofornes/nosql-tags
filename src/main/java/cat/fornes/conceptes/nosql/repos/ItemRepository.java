/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cat.fornes.conceptes.nosql.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.Nullable;

import cat.fornes.conceptes.nosql.models.items.Item;
import cat.fornes.conceptes.nosql.models.tags.NamedTag;

/**
 * Item repository.
 *
 * @author Octavi Fornés &lt;ofornes@albirar.cat&gt;
 * @since 1.0.0
 */
public interface ItemRepository extends MongoRepository<Item, String>
{
	/**
	 * Cerca item pel nom.
	 * @param name El nom
	 * @return L'item o {@link Optional#empty()} si no se'n troba cap amb el nom indicat
	 */
	Optional<Item> findByName(String name);
	
	/**
	 * Cerca items per nom semblant.
	 * @param name El nom
	 * @return L'item o {@link Optional#empty()} si no se'n troba cap amb el nom indicat
	 */
	List<Item> findByNameLike(String name);
	/**
	 * Cerca items associats amb el tag indicat.
	 * @param tagValue El tag
	 * @param sort Opcional, per a indicar l'ordenació
	 * @return La llista -pot ser buida- amb el resultat en l'ordre indicat
	 */
	List<Item> findByTagsContaining(String tagValue, @Nullable Sort sort);
	
	/**
	 * Cerca items associats amb un {@link NamedTag} de {@link NamedTag#getName() nom} {@code tagName}.
	 * @param tagName El nom del tag
	 * @param sort Opcional, per a indicar l'ordenació
	 * @return La llista -pot ser buida- amb el resultat en l'ordre indicat
	 */
	List<Item> findByNamedTags_NameEquals(String tagName, @Nullable Sort sort);
	
	/**
	 * Cerca items associats amb un {@link NamedTag} de {@link NamedTag#getName() nom} {@code tagName} i que conté el {@code value} en la llista de {@link NamedTag#getValues() valors}.
	 * @param tagName El nom del tag
	 * @param value El valor del tag
	 * @param sort Opcional, per a indicar l'ordenació
	 * @return La llista -pot ser buida- amb el resultat en l'ordre indicat
	 */
	List<Item> findByNamedTags_NameEqualsAndNamedTags_ValuesContaining(String tagName, String value, @Nullable Sort sort);
}
