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
package cat.fornes.conceptes.nosql;

import java.util.List;

import org.assertj.core.util.Arrays;

import cat.fornes.conceptes.nosql.models.items.Item;
import cat.fornes.conceptes.nosql.models.tags.NamedTag;

/**
 * TODO Documentation!
 *
 * @author Octavi Fornés &lt;ofornes@albirar.cat&gt;
 * @since 1.0.0
 */
public abstract class ArrelNosqlTagsTestAbstracte
{
	public static final String TAG_VERDURA = "verdura";
	public static final String TAG_CARN = "carn";
	public static final String TAG_PEIX = "peix";
	public static final String TAG_EMBOTIT = "embotit";
	public static final String TAG_PRINCIPAL = "principal";
	public static final String TAG_ACCESSORI = "accessori";
	public static final String [] TAGS = {TAG_VERDURA, TAG_CARN, TAG_PEIX, TAG_EMBOTIT};

	public static final String NOM_TAG_BOTIGA = "botiga";
	public static final String NOM_TAG_SALSA = "salsa";
	public static final String NOM_TAG_CONDIMENT = "condiment";
	
	public static final String VALUE_SPAR = "Spar";
	public static final String VALUE_AURELIA = "Ca l'Aurèlia";
	public static final String VALUE_BONAREA = "Bonàrea";
	public static final String VALUE_CAPRABO = "Caprabo";
	public static final String VALUE_CALAVIA = "Ca l'àvia";
	
	public static final String VALUE_TOMAQUET ="tomàquet";
	public static final String VALUE_ROMESCO ="romesco";

	public static final String VALUE_AMANIDES ="amanides";
	public static final String VALUE_MACARRONS ="macarrons";

	public static final String ITEM_NAME_TOMAQUET = "Tomàquet";
	public static final String ITEM_NAME_PERNIL = "Pernil";
	public static final String ITEM_NAME_HAMBURGUESA = "Hamburguesa";
	public static final String ITEM_NAME_SARDINES = "Sardines";
	
	public static final NamedTag [] NAMED_TAGS_TOMAQUET = {
			NamedTag.builder().name(NOM_TAG_BOTIGA).value(VALUE_AURELIA).value(VALUE_BONAREA).value(VALUE_SPAR).value(VALUE_CAPRABO).build()
			,NamedTag.builder().name(NOM_TAG_SALSA).value(VALUE_TOMAQUET).value(VALUE_ROMESCO).build()
			,NamedTag.builder().name(NOM_TAG_CONDIMENT).value(VALUE_AMANIDES).value(VALUE_MACARRONS).build()
	};
	
	public static final NamedTag [] NAMED_TAGS_PERNIL = {
			NamedTag.builder().name(NOM_TAG_BOTIGA).value(VALUE_CAPRABO).value(VALUE_BONAREA).value(VALUE_SPAR).build()
			,NamedTag.builder().name(NOM_TAG_SALSA).value(VALUE_TOMAQUET).build()
			,NamedTag.builder().name(NOM_TAG_CONDIMENT).value(VALUE_AMANIDES).value(VALUE_MACARRONS).build()
	};
	
	public static final NamedTag [] NAMED_TAGS_HAMBURGUESA = {
			NamedTag.builder().name(NOM_TAG_BOTIGA).value(VALUE_CAPRABO).value(VALUE_BONAREA).value(VALUE_SPAR).build()
			,NamedTag.builder().name(NOM_TAG_SALSA).value(VALUE_TOMAQUET).build()
			,NamedTag.builder().name(NOM_TAG_CONDIMENT).value(VALUE_MACARRONS).build()
	};
	public static final NamedTag [] NAMED_TAGS_SARDINES = {
			NamedTag.builder().name(NOM_TAG_BOTIGA).value(VALUE_CALAVIA).value(VALUE_CAPRABO).build()
			,NamedTag.builder().name(NOM_TAG_CONDIMENT).value(VALUE_AMANIDES).build()
	};
	
	@SuppressWarnings( {"unchecked", "rawtypes"} )
	public static final Item [] ITEMS = {
			Item.builder().name(ITEM_NAME_TOMAQUET).tag(TAG_ACCESSORI).tag(TAG_PRINCIPAL).tag(TAG_VERDURA).namedTags((List)Arrays.asList(NAMED_TAGS_TOMAQUET)).build()
			, Item.builder().name(ITEM_NAME_PERNIL).tag(TAG_ACCESSORI).tag(TAG_PRINCIPAL).tag(TAG_EMBOTIT).tag(TAG_CARN).namedTags((List)Arrays.asList(NAMED_TAGS_PERNIL)).build()
			, Item.builder().name(ITEM_NAME_HAMBURGUESA).tag(TAG_PRINCIPAL).tag(TAG_CARN).namedTags((List)Arrays.asList(NAMED_TAGS_HAMBURGUESA)).build()
			, Item.builder().name(ITEM_NAME_SARDINES).tag(TAG_PRINCIPAL).tag(TAG_PEIX).namedTags((List)Arrays.asList(NAMED_TAGS_SARDINES)).build()
	};
}
