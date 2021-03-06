/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;
import pt.simdea.gmlrva.sample.R;
import pt.simdea.gmlrva.sample.utilities.GenericUtils;

/**
 * Class representing a Carousel Category Layout meant to be used on a {@link GenericMultipleLayoutAdapter}.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor public class CarouselCategoryItemLayout
        implements IGenericRecyclerViewLayout<CarouselCategoryItemLayout.CarouselCategoryViewHolder> {

    private final String mCategoryTitle;
    private final List<? extends IGenericRecyclerViewLayout> mCategoryData;
    private final Context mContext;

    @NonNull @Override public CarouselCategoryViewHolder createViewHolder(@NonNull final ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gmlrva_layout_carousel_category_item, parent, false);
        return new CarouselCategoryViewHolder(view);
    }

    @Override public void setElements(@NonNull final CarouselCategoryViewHolder holder) {
        holder.getTitle().setText(mCategoryTitle);
        loadItems(holder.getItems());
    }

    @NonNull @Override public Object getTag() {
        return mCategoryTitle;
    }

    @Override public int getViewType() {
        return 1;
    }

    /**
     * Procedure meant to load the Carousel Item Layout items, bound by this Carousel Category Layout.
     * @param items the {@link RecyclerView} which will hold the Carousel Item Layout items.
     */
    private void loadItems(@NonNull final RecyclerView items) {
        items.setAdapter(new GenericMultipleLayoutAdapter(mCategoryData, mContext, false));
        items.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        GenericUtils.setOptimalConfigurationForRecyclerView(items);
    }

    /** Class meant to define the {@link RecyclerView.ViewHolder} for a Carousel Category Layout instance. */
    class CarouselCategoryViewHolder extends RecyclerView.ViewHolder {
        @Getter private TextView mTitle;
        @Getter private RecyclerView mItems;

        /**
         * Instantiates a new CarouselCategoryViewHolder.
         * @param view this {@link RecyclerView.ViewHolder}'s root view.
         */
        CarouselCategoryViewHolder(@NonNull final View view) {
            super(view);
            bindViews(view);
        }

        /**
         * Procedure meant to bind this {@link RecyclerView.ViewHolder}'s views.
         * @param view this {@link CarouselCategoryViewHolder}'s root view.
         */
        private void bindViews(@NonNull final View view) {
            mTitle = (TextView) view.findViewById(R.id.tvCarouselCategoryItemTitle);
            mItems = (RecyclerView) view.findViewById(R.id.rvCarouselCategoryItemData);
        }

    }

}
