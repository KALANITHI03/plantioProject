package com.example.plantio1.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plantio1.Entity.Product;
import com.example.plantio1.Entity.User;
import com.example.plantio1.Entity.card;
import com.example.plantio1.Repository.CartRepository;
import com.example.plantio1.Repository.ProductRepository;
import com.example.plantio1.Repository.UserRepository;

@Service
public class CartServices {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userrepository;


    // Get all cart items
    public List<card> getAllCard() {

        return cartRepository.findAll();
    }


    // Add product to cart
    public card addCardItem(Long userid, Long productId, int qty) {

        Optional<User> user = userrepository.findById(userid);

        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }


        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            throw new RuntimeException("Product not found");
        }


        Optional<card> existingCart =
                cartRepository.findByUserIdAndProductId(userid, productId);


        if (existingCart.isPresent()) {

            card cart = existingCart.get();

            cart.setQuantity(cart.getQuantity() + qty);

            return cartRepository.save(cart);

        } else {

            card cart = new card();

            cart.setUser(user.get());
            cart.setProduct(product.get());
            cart.setQuantity(qty);

            return cartRepository.save(cart);
        }
    }


    // Remove one cart item using cartId
    public void removeCartItem(Long cartId) {

        Optional<card> cart = cartRepository.findById(cartId);

        if (cart.isEmpty()) {
            throw new RuntimeException("Cart item not found");
        }

        cartRepository.deleteById(cartId);
    }


    // Increase quantity using cartId
    public void increaseItemQuantity(Long cartId) {

        Optional<card> cart = cartRepository.findById(cartId);

        if (cart.isEmpty()) {
            throw new RuntimeException("Cart item not found");
        }

        card exitingCard = cart.get();

        exitingCard.setQuantity(exitingCard.getQuantity() + 1);

        cartRepository.save(exitingCard);
    }


    // Decrease quantity using cartId
    public void decreaseItemQuantity(Long cartId) {

        Optional<card> cart = cartRepository.findById(cartId);

        if (cart.isEmpty()) {
            throw new RuntimeException("Cart item not found");
        }

        card exitingCard = cart.get();

        if (exitingCard.getQuantity() > 1) {

            exitingCard.setQuantity(exitingCard.getQuantity() - 1);

            cartRepository.save(exitingCard);

        } else {

            cartRepository.deleteById(cartId);
        }
    }


    // Delete all cart items of a user
    public void deleteAllCart(Long userid) {

        Optional<User> user = userrepository.findById(userid);

        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        List<card> cart = cartRepository.findByUserId(userid);

        cartRepository.deleteAll(cart);
    }

}